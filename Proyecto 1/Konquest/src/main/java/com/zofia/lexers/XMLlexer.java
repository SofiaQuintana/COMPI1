/* The following code was generated by JFlex 1.7.0 */

package com.zofia.lexers;
import java_cup.runtime.*;
import com.zofia.parsers.SAVING.sym;
import com.zofia.frontend.PrincipalFrame;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>/home/zofia/Documents/COMPI1_XELA_2020/Proyecto 1/Konquest/src/main/java/com/zofia/lexers/XMLStructure</tt>
 */
public class XMLlexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\10\0\2\6\1\5\1\67\1\6\1\4\22\0\1\6\1\0\1\7"+
    "\1\0\1\2\10\0\1\10\1\12\1\66\1\11\11\3\2\0\1\63"+
    "\1\65\1\64\2\0\1\21\1\1\1\47\1\56\1\15\1\62\1\16"+
    "\1\61\1\26\1\13\1\1\1\53\1\20\1\46\1\17\1\22\1\55"+
    "\1\52\1\25\1\51\1\14\4\1\1\27\4\0\1\2\1\0\1\32"+
    "\1\57\1\34\1\24\1\44\1\30\1\50\1\1\1\23\1\60\1\1"+
    "\1\31\1\37\1\40\1\35\1\45\1\1\1\42\1\33\1\43\1\36"+
    "\1\54\3\1\1\41\12\0\1\67\u1fa2\0\1\67\1\67\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\2\3\1\1\1\2\21\1\1\4"+
    "\1\5\1\6\1\7\6\0\1\10\26\0\1\11\1\12"+
    "\1\13\33\0\1\14\2\0\1\15\1\0\1\16\13\0"+
    "\1\17\1\20\12\0\1\21\2\0\1\22\1\0\1\23"+
    "\2\0\1\24\3\0\1\25\11\0\1\26\4\0\1\27"+
    "\4\0\1\30\7\0\1\31\1\0\1\32\12\0\1\33"+
    "\1\0\1\34\2\0\1\35\1\0\1\36\1\37\12\0"+
    "\1\40\1\0\1\41\6\0\1\42\7\0\1\43\10\0"+
    "\1\44\1\45\1\46\1\0\1\47\17\0\1\50\1\51"+
    "\1\0\1\52";

  private static int [] zzUnpackAction() {
    int [] result = new int[238];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\70\0\160\0\250\0\70\0\340\0\u0118\0\u0150"+
    "\0\u0188\0\u01c0\0\u01f8\0\u0230\0\u0268\0\u02a0\0\u02d8\0\u0310"+
    "\0\u0348\0\u0380\0\u03b8\0\u03f0\0\u0428\0\u0460\0\u0498\0\u04d0"+
    "\0\70\0\70\0\70\0\70\0\u0508\0\u0540\0\u0578\0\u05b0"+
    "\0\u05e8\0\u0620\0\70\0\u0658\0\u0690\0\u06c8\0\u0700\0\u0738"+
    "\0\u0770\0\u07a8\0\u07e0\0\u0818\0\u0850\0\u0888\0\u08c0\0\u08f8"+
    "\0\u0930\0\u0968\0\u09a0\0\u09d8\0\u0a10\0\u0a48\0\u0a80\0\u0ab8"+
    "\0\u0af0\0\70\0\70\0\u0578\0\u0b28\0\u0b60\0\u0b98\0\u0bd0"+
    "\0\u0c08\0\u0c40\0\u0c78\0\u0cb0\0\u0ce8\0\u0d20\0\u0d58\0\u0d90"+
    "\0\u0dc8\0\u0e00\0\u0e38\0\u0e70\0\u0ea8\0\u0ee0\0\u0f18\0\u0f50"+
    "\0\u0f88\0\u0fc0\0\u0ff8\0\u1030\0\u1068\0\u10a0\0\u10d8\0\70"+
    "\0\u1110\0\u1148\0\70\0\u1180\0\70\0\u11b8\0\u11f0\0\u1228"+
    "\0\u1260\0\u1298\0\u12d0\0\u1308\0\u1340\0\u1378\0\u13b0\0\u13e8"+
    "\0\70\0\70\0\u1420\0\u1458\0\u1490\0\u14c8\0\u1500\0\u1538"+
    "\0\u1570\0\u15a8\0\u15e0\0\u1618\0\70\0\u1650\0\u1688\0\70"+
    "\0\u16c0\0\70\0\u16f8\0\u1730\0\70\0\u1768\0\u17a0\0\u17d8"+
    "\0\70\0\u1810\0\u1848\0\u1880\0\u18b8\0\u18f0\0\u1928\0\u1960"+
    "\0\u1998\0\u19d0\0\70\0\u1a08\0\u1a40\0\u1a78\0\u1ab0\0\70"+
    "\0\u1ae8\0\u1b20\0\u1b58\0\u1b90\0\70\0\u1bc8\0\u1c00\0\u1c38"+
    "\0\u1c70\0\u1ca8\0\u1ce0\0\u1d18\0\70\0\u1d50\0\u1d88\0\u1dc0"+
    "\0\u1df8\0\u1e30\0\u1e68\0\u1ea0\0\u1ed8\0\u1f10\0\u1f48\0\u1f80"+
    "\0\u1fb8\0\u1ff0\0\u2028\0\70\0\u2060\0\u2098\0\70\0\u20d0"+
    "\0\70\0\70\0\u2108\0\u2140\0\u2178\0\u21b0\0\u21e8\0\u2220"+
    "\0\u2258\0\u2290\0\u22c8\0\u2300\0\70\0\u2338\0\70\0\u2370"+
    "\0\u23a8\0\u23e0\0\u2418\0\u2450\0\u2488\0\70\0\u24c0\0\u24f8"+
    "\0\u2530\0\u2568\0\u25a0\0\u25d8\0\u2610\0\70\0\u2648\0\u2680"+
    "\0\u26b8\0\u26f0\0\u2728\0\u2760\0\u2798\0\u27d0\0\70\0\70"+
    "\0\70\0\u2808\0\70\0\u2840\0\u2878\0\u28b0\0\u28e8\0\u2920"+
    "\0\u2958\0\u2990\0\u29c8\0\u2a00\0\u2a38\0\u2a70\0\u2aa8\0\u2ae0"+
    "\0\u2b18\0\u2b50\0\70\0\70\0\u2b88\0\70";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[238];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\3\2\1\3\1\4\2\5\1\6\1\2\1\7\1\2"+
    "\1\10\4\2\1\11\1\2\1\12\1\13\1\2\1\14"+
    "\2\2\1\15\1\2\1\16\1\2\1\17\2\2\1\20"+
    "\1\21\2\2\1\22\1\2\1\23\1\24\1\25\6\2"+
    "\1\26\2\2\1\27\1\30\1\31\1\32\1\33\1\34"+
    "\74\0\1\3\5\0\1\3\63\0\1\5\63\0\1\35"+
    "\1\36\10\0\50\35\17\0\1\37\71\0\1\40\74\0"+
    "\1\41\121\0\1\42\40\0\1\43\71\0\1\44\64\0"+
    "\1\45\6\0\1\46\66\0\1\47\2\0\1\50\70\0"+
    "\1\51\64\0\1\52\2\0\1\53\64\0\1\54\2\0"+
    "\1\55\55\0\1\56\16\0\1\57\56\0\1\60\3\0"+
    "\1\61\4\0\1\62\42\0\1\63\71\0\1\64\76\0"+
    "\1\65\55\0\1\66\74\0\1\67\47\0\1\70\1\36"+
    "\1\71\3\0\1\72\1\36\2\0\50\70\6\0\3\36"+
    "\3\0\1\73\1\36\2\0\50\36\10\0\1\74\5\0"+
    "\1\74\73\0\1\75\1\76\73\0\1\77\66\0\1\100"+
    "\75\0\1\101\71\0\1\102\6\0\1\103\60\0\1\104"+
    "\57\0\1\105\104\0\1\106\62\0\1\107\103\0\1\110"+
    "\55\0\1\111\110\0\1\112\52\0\1\113\75\0\1\114"+
    "\60\0\1\115\63\0\1\116\77\0\1\117\62\0\1\120"+
    "\46\0\1\121\121\0\1\122\103\0\1\123\25\0\1\124"+
    "\116\0\1\125\21\0\1\126\1\36\1\127\3\0\1\72"+
    "\1\36\2\0\50\126\6\0\1\127\1\36\1\127\3\0"+
    "\1\130\1\36\2\0\50\127\23\0\1\131\72\0\1\132"+
    "\67\0\1\133\114\0\1\134\36\0\1\135\104\0\1\136"+
    "\67\0\1\137\70\0\1\140\75\0\1\141\65\0\1\142"+
    "\65\0\1\143\1\144\63\0\1\145\100\0\1\146\70\0"+
    "\1\147\102\0\1\150\45\0\1\151\76\0\1\152\63\0"+
    "\1\153\63\0\1\154\57\0\1\155\20\0\1\156\73\0"+
    "\1\157\73\0\1\160\40\0\1\161\62\0\1\162\74\0"+
    "\1\163\42\0\1\164\1\36\1\164\3\0\1\72\1\36"+
    "\2\0\50\164\6\0\1\164\1\36\1\164\3\0\1\130"+
    "\1\36\2\0\50\164\24\0\1\165\126\0\1\166\26\0"+
    "\1\167\105\0\1\170\65\0\1\171\102\0\1\172\55\0"+
    "\1\173\73\0\1\174\73\0\1\175\64\0\1\176\77\0"+
    "\1\177\62\0\1\200\60\0\1\201\76\0\1\202\71\0"+
    "\1\203\67\0\1\204\61\0\1\205\54\0\1\206\116\0"+
    "\1\207\31\0\1\210\122\0\1\211\66\0\1\212\74\0"+
    "\1\213\15\0\1\214\1\36\1\214\3\0\1\130\1\36"+
    "\2\0\50\214\24\0\1\215\121\0\1\216\41\0\1\217"+
    "\106\0\1\220\56\0\1\221\76\0\1\222\52\0\1\223"+
    "\76\0\1\224\101\0\1\225\66\0\1\226\64\0\1\227"+
    "\63\0\1\230\77\0\1\231\44\0\1\232\74\0\1\233"+
    "\67\0\1\234\60\0\1\235\51\0\1\236\1\36\1\236"+
    "\3\0\1\130\1\36\2\0\50\236\57\0\1\237\36\0"+
    "\1\240\107\0\1\241\60\0\1\242\67\0\1\243\101\0"+
    "\1\244\65\0\1\245\57\0\1\246\100\0\1\247\60\0"+
    "\1\250\76\0\1\251\77\0\1\252\41\0\1\253\115\0"+
    "\1\254\15\0\1\255\1\36\1\255\3\0\1\130\1\36"+
    "\2\0\50\255\22\0\1\256\77\0\1\257\74\0\1\260"+
    "\77\0\1\261\60\0\1\262\104\0\1\263\34\0\1\264"+
    "\30\0\1\265\54\0\1\266\66\0\1\267\60\0\1\270"+
    "\76\0\1\271\52\0\1\272\123\0\1\273\17\0\1\274"+
    "\1\36\1\274\3\0\1\130\1\36\2\0\50\274\32\0"+
    "\1\275\76\0\1\276\70\0\1\277\65\0\1\300\66\0"+
    "\1\301\103\0\1\302\101\0\1\303\44\0\1\304\74\0"+
    "\1\305\52\0\1\306\63\0\1\307\47\0\1\310\1\36"+
    "\1\310\3\0\1\130\1\36\2\0\50\310\30\0\1\311"+
    "\107\0\1\312\100\0\1\313\57\0\1\314\67\0\1\315"+
    "\63\0\1\316\52\0\1\317\122\0\1\320\12\0\1\321"+
    "\1\36\1\321\3\0\1\130\1\36\2\0\50\321\42\0"+
    "\1\322\64\0\1\323\101\0\1\324\61\0\1\325\51\0"+
    "\1\326\104\0\1\327\51\0\1\330\51\0\3\36\3\0"+
    "\1\130\1\36\2\0\50\36\45\0\1\331\53\0\1\332"+
    "\76\0\1\333\77\0\1\334\62\0\1\335\54\0\1\336"+
    "\106\0\1\337\71\0\1\340\56\0\1\341\66\0\1\342"+
    "\77\0\1\343\70\0\1\344\55\0\1\345\101\0\1\346"+
    "\47\0\1\347\110\0\1\350\67\0\1\351\57\0\1\352"+
    "\66\0\1\353\67\0\1\354\66\0\1\355\70\0\1\356"+
    "\34\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[11200];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\2\1\1\11\23\1\4\11\6\0\1\11"+
    "\26\0\2\11\1\1\33\0\1\11\2\0\1\11\1\0"+
    "\1\11\13\0\2\11\12\0\1\11\2\0\1\11\1\0"+
    "\1\11\2\0\1\11\3\0\1\11\11\0\1\11\4\0"+
    "\1\11\4\0\1\11\7\0\1\11\1\0\1\1\12\0"+
    "\1\1\1\0\1\11\2\0\1\11\1\0\2\11\12\0"+
    "\1\11\1\0\1\11\6\0\1\11\7\0\1\11\10\0"+
    "\3\11\1\0\1\11\17\0\2\11\1\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[238];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true iff the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true iff the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
    private PrincipalFrame frame;
    
    public XMLlexer(java.io.Reader in, PrincipalFrame frame) {
        this.zzReader = in;
        this.frame = frame;
    }

    private Symbol symbol(int type) {
        return new Symbol(type, yyline+1, yycolumn+1);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline+1, yycolumn+1, value);
    }

    private void printToken(String token){
        System.out.println(token);
    }

    private void error(String value, int line, int column) {
        frame.printLexicalError(value, line, column);
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public XMLlexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 190) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
              {
                return symbol(sym.EOF);
              }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { printToken("ERROR: " + yytext()); error(yytext(), yyline+1, yycolumn+1);
            } 
            // fall through
          case 43: break;
          case 2: 
            { printToken(yytext()); return symbol(sym.INTEGER, yytext());
            } 
            // fall through
          case 44: break;
          case 3: 
            { /*do nothing*/
            } 
            // fall through
          case 45: break;
          case 4: 
            { printToken("<"); return symbol(sym.MAYORQUE, "<");
            } 
            // fall through
          case 46: break;
          case 5: 
            { printToken(">"); return symbol(sym.MENORQUE, ">");
            } 
            // fall through
          case 47: break;
          case 6: 
            { printToken("="); return symbol(sym.EQUAL, "=");
            } 
            // fall through
          case 48: break;
          case 7: 
            { printToken("/"); return symbol(sym.SLASH, "/");
            } 
            // fall through
          case 49: break;
          case 8: 
            { printToken("Id"); return symbol(sym.id, "id");
            } 
            // fall through
          case 50: break;
          case 9: 
            { printToken("Name " + yytext()); return symbol(sym.NAME, yytext());
            } 
            // fall through
          case 51: break;
          case 10: 
            { printToken("Id " + yytext()); return symbol(sym.ID, yytext());
            } 
            // fall through
          case 52: break;
          case 11: 
            { printToken(yytext()); return symbol(sym.PERCENTAGE, yytext());
            } 
            // fall through
          case 53: break;
          case 12: 
            { printToken("Player " + yytext()); return symbol(sym.PLAYER, yytext());
            } 
            // fall through
          case 54: break;
          case 13: 
            { printToken("MAPA"); return symbol(sym.MAPA, "MAPA");
            } 
            // fall through
          case 55: break;
          case 14: 
            { printToken("SIZE"); return symbol(sym.SIZE, "SIZE");
            } 
            // fall through
          case 56: break;
          case 15: 
            { printToken("tipo"); return symbol(sym.tipo, "tipo");
            } 
            // fall through
          case 57: break;
          case 16: 
            { printToken("true"); return symbol(sym.TRUE, "true");
            } 
            // fall through
          case 58: break;
          case 17: 
            { printToken("JUEGO"); return symbol(sym.JUEGO, "JUEGO");
            } 
            // fall through
          case 59: break;
          case 18: 
            { printToken("filas"); return symbol(sym.filas, "filas");
            } 
            // fall through
          case 60: break;
          case 19: 
            { printToken("false"); return symbol(sym.FALSE, "false");
            } 
            // fall through
          case 61: break;
          case 20: 
            { printToken("color"); return symbol(sym.color, "color");
            } 
            // fall through
          case 62: break;
          case 21: 
            { printToken("naves"); return symbol(sym.naves, "naves");
            } 
            // fall through
          case 63: break;
          case 22: 
            { printToken("FACIL"); return symbol(sym.FACIL, "FACIL");
            } 
            // fall through
          case 64: break;
          case 23: 
            { printToken("alAzar"); return symbol(sym.alAzar, "alAzar");
            } 
            // fall through
          case 65: break;
          case 24: 
            { printToken("nombre"); return symbol(sym.nombre, "nombre");
            } 
            // fall through
          case 66: break;
          case 25: 
            { printToken("HUMANO"); return symbol(sym.HUMANO, "HUMANO");
            } 
            // fall through
          case 67: break;
          case 26: 
            { printToken("JUGADOR"); return symbol(sym.JUGADOR, "JUGADOR");
            } 
            // fall through
          case 68: break;
          case 27: 
            { printToken("NEUTRAL"); return symbol(sym.NEUTRAL, "NEUTRAL");
            } 
            // fall through
          case 69: break;
          case 28: 
            { printToken("DIFICIL"); return symbol(sym.DIFICIL, "DIFICIL");
            } 
            // fall through
          case 70: break;
          case 29: 
            { printToken("PLANETAS"); return symbol(sym.PLANETAS, "PLANETAS");
            } 
            // fall through
          case 71: break;
          case 30: 
            { printToken("acumular"); return symbol(sym.acumular, "acumular");
            } 
            // fall through
          case 72: break;
          case 31: 
            { printToken("columnas"); return symbol(sym.columnas, "columnas");
            } 
            // fall through
          case 73: break;
          case 32: 
            { printToken("JUGADORES"); return symbol(sym.JUGADORES, "JUGADORES");
            } 
            // fall through
          case 74: break;
          case 33: 
            { printToken("mapaCiego"); return symbol(sym.mapaCiego, "mapaCiego");
            } 
            // fall through
          case 75: break;
          case 34: 
            { printToken("NEUTRALES"); return symbol(sym.NEUTRALES, "NEUTRALES");
            } 
            // fall through
          case 76: break;
          case 35: 
            { printToken("produccion"); return symbol(sym.produccion, "produccion");
            } 
            // fall through
          case 77: break;
          case 36: 
            { printToken("propietario"); return symbol(sym.propietario, "propietario");
            } 
            // fall through
          case 78: break;
          case 37: 
            { printToken("CONQUISTADO"); return symbol(sym.CONQUISTADO, "CONQUISTADO");
            } 
            // fall through
          case 79: break;
          case 38: 
            { printToken("finalizacion"); return symbol(sym.finalizacion, "finalizacion");
            } 
            // fall through
          case 80: break;
          case 39: 
            { printToken("mostrarNaves"); return symbol(sym.mostrarNaves, "mostrarNaves");
            } 
            // fall through
          case 81: break;
          case 40: 
            { printToken("planetasNeutrales"); return symbol(sym.planetasNeutrales, "planetasNeutrales");
            } 
            // fall through
          case 82: break;
          case 41: 
            { printToken("porcentajeMuertes"); return symbol(sym.porcentajeMuertes, "porcentajeMuertes");
            } 
            // fall through
          case 83: break;
          case 42: 
            { printToken("mostrarEstadisticas"); return symbol(sym.mostrarEstadisticas, "mostrarEstadisticas");
            } 
            // fall through
          case 84: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }

  /**
   * Converts an int token code into the name of the
   * token by reflection on the cup symbol class/interface sym
   *
   * This code was contributed by Karl Meissner <meissnersd@yahoo.com>
   */
  private String getTokenName(int token) {
    try {
      java.lang.reflect.Field [] classFields = sym.class.getFields();
      for (int i = 0; i < classFields.length; i++) {
        if (classFields[i].getInt(null) == token) {
          return classFields[i].getName();
        }
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

    return "UNKNOWN TOKEN";
  }

  /**
   * Same as next_token but also prints the token to standard out
   * for debugging.
   *
   * This code was contributed by Karl Meissner <meissnersd@yahoo.com>
   */
  public java_cup.runtime.Symbol debug_next_token() throws java.io.IOException {
    java_cup.runtime.Symbol s = next_token();
    System.out.println( "line:" + (yyline+1) + " col:" + (yycolumn+1) + " --"+ yytext() + "--" + getTokenName(s.sym) + "--");
    return s;
  }

  /**
   * Runs the scanner on input files.
   *
   * This main method is the debugging routine for the scanner.
   * It prints debugging information about each returned token to
   * System.out until the end of file is reached, or an error occured.
   *
   * @param argv   the command line, contains the filenames to run
   *               the scanner on.
   */
  public static void main(String argv[]) {
    if (argv.length == 0) {
      System.out.println("Usage : java XMLlexer [ --encoding <name> ] <inputfile(s)>");
    }
    else {
      int firstFilePos = 0;
      String encodingName = "UTF-8";
      if (argv[0].equals("--encoding")) {
        firstFilePos = 2;
        encodingName = argv[1];
        try {
          java.nio.charset.Charset.forName(encodingName); // Side-effect: is encodingName valid? 
        } catch (Exception e) {
          System.out.println("Invalid encoding '" + encodingName + "'");
          return;
        }
      }
      for (int i = firstFilePos; i < argv.length; i++) {
        XMLlexer scanner = null;
        try {
          java.io.FileInputStream stream = new java.io.FileInputStream(argv[i]);
          java.io.Reader reader = new java.io.InputStreamReader(stream, encodingName);
          scanner = new XMLlexer(reader);
          while ( !scanner.zzAtEOF ) scanner.debug_next_token();
        }
        catch (java.io.FileNotFoundException e) {
          System.out.println("File not found : \""+argv[i]+"\"");
        }
        catch (java.io.IOException e) {
          System.out.println("IO error scanning file \""+argv[i]+"\"");
          System.out.println(e);
        }
        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
      }
    }
  }


}
