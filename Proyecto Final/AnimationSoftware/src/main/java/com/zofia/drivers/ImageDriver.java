/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.drivers;

import com.zofia.dummyclasses.Square;
import com.zofia.gui.ImagePanel;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOInvalidTreeException;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;

/**
 *
 * @author zofia
 */
public class ImageDriver {
    private ImageWriter writer; //Escritor de la imagen 
    private ImageWriteParam parameters; //Escritor de los parametros de la imagen 
    private IIOMetadata metadata; //Metadata

    public ImageDriver() {
        //Constructor vacio
    }

    public ImageDriver(ImageOutputStream output, int type, int delay, boolean loop) throws IOException {
        writer = ImageIO.getImageWritersBySuffix("gif").next();
        parameters = writer.getDefaultWriteParam();

        ImageTypeSpecifier imageTypeSpecifier = ImageTypeSpecifier.createFromBufferedImageType(type);
        metadata = writer.getDefaultImageMetadata(imageTypeSpecifier, parameters);

        configureRootMetadata(delay, loop);

        writer.setOutput(output);
        writer.prepareWriteSequence(null);
    }

    private void configureRootMetadata(int delay, boolean loop) throws IIOInvalidTreeException {
        String metaFormatName = metadata.getNativeMetadataFormatName();
        IIOMetadataNode root = (IIOMetadataNode) metadata.getAsTree(metaFormatName);
        
        IIOMetadataNode graphicsControlExtensionNode = getNode(root, "GraphicControlExtension");
        graphicsControlExtensionNode.setAttribute("disposalMethod", "none");
        graphicsControlExtensionNode.setAttribute("userInputFlag", "FALSE");
        graphicsControlExtensionNode.setAttribute("transparentColorFlag", "FALSE");
        graphicsControlExtensionNode.setAttribute("delayTime", Integer.toString(delay / 10));
        graphicsControlExtensionNode.setAttribute("transparentColorIndex", "0");

        IIOMetadataNode commentsNode = getNode(root, "CommentExtensions");
        commentsNode.setAttribute("CommentExtension", "Created by: sofia:p");

        IIOMetadataNode appExtensionsNode = getNode(root, "ApplicationExtensions");
        IIOMetadataNode child = new IIOMetadataNode("ApplicationExtension");
        child.setAttribute("applicationID", "NETSCAPE");
        child.setAttribute("authenticationCode", "2.0");

        int loopContinuously = loop ? 0 : 1;
        child.setUserObject(new byte[]{ 0x1, (byte) (loopContinuously & 0xFF), (byte) ((loopContinuously >> 8) & 0xFF)});
        appExtensionsNode.appendChild(child);
        metadata.setFromTree(metaFormatName, root);
    }

    private static IIOMetadataNode getNode(IIOMetadataNode rootNode, String nodeName){
        int nNodes = rootNode.getLength();
        for (int i = 0; i < nNodes; i++){
            if (rootNode.item(i).getNodeName().equalsIgnoreCase(nodeName)){
                return (IIOMetadataNode) rootNode.item(i);
            }
        }
        IIOMetadataNode node = new IIOMetadataNode(nodeName);
        rootNode.appendChild(node);
        return(node);
    }

    public void writeToSequence(RenderedImage img, int time) throws IOException {
        this.configureRootMetadata(time, true);
        writer.writeToSequence(new IIOImage(img, null, metadata), parameters);
    }

    public void close() throws IOException {
        writer.endWriteSequence();
    }
    
     public BufferedImage createBufferedImage(ImagePanel image, Square square){
        Dimension dimension = square.getDimension();
        int size = square.getSize();
        image.setPreferredSize(new Dimension((int)dimension.getHeight()*size, (int)dimension.getWidth()*size));
        image.setSize(image.getPreferredSize());
        image.doLayout();
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = bufferedImage.createGraphics();
        image.print(graphics);
        graphics.dispose();
        return bufferedImage;
    }
    
   
    public void createGif(ArrayList<BufferedImage> images, ArrayList<Integer> times, String imageName) {
        try {
            BufferedImage firstImage = images.get(0);
            ImageOutputStream output = new FileImageOutputStream(new File(imageName));
            ImageDriver driver =  new ImageDriver(output, firstImage.getType(), times.get(0), true);
            driver.writeToSequence(firstImage, times.get(0));
            for(int i = 1; i <images.size(); i++) {
                BufferedImage nextImage = images.get(i);
                driver.writeToSequence(nextImage, times.get(i));
            }
            driver.close();
            output.close();
        } 
        catch (IOException ex) {
            System.out.println("Error creando la imagen gif.");
        }
    }
}
