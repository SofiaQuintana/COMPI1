/* The following code was generated by JFlex 1.7.0 */

package com.zofia.lexers;
import java_cup.runtime.*;
import com.zofia.parsers.canvas.sym;
import com.zofia.drivers.CanvasDriver;
import com.zofia.logic.Error;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>/home/zofia/Documents/COMPI1_XELA_2020/Proyecto Final/AnimationSoftware/src/main/java/com/zofia/lexers/CanvasLexer.flex</tt>
 */
public class CanvasLexer implements java_cup.runtime.Scanner {

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
    "\10\0\2\6\1\5\1\60\1\6\1\4\22\0\1\6\1\0\1\10"+
    "\1\12\6\0\1\11\1\0\1\57\3\0\12\2\1\56\6\0\1\3"+
    "\1\36\2\3\1\15\1\33\1\41\1\50\1\14\2\1\1\13\1\1"+
    "\1\16\1\20\2\1\1\35\1\21\4\1\1\51\1\1\1\17\4\0"+
    "\1\7\1\0\1\42\1\25\1\44\1\34\1\27\1\53\1\52\1\1"+
    "\1\31\2\1\1\37\1\24\1\22\1\23\1\32\1\1\1\26\1\45"+
    "\1\30\1\40\2\1\1\46\1\47\1\1\1\54\1\0\1\55\7\0"+
    "\1\60\153\0\1\43\u1f36\0\1\60\1\60\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\2\4\2\1\12\2\1\5"+
    "\1\6\1\7\1\10\4\0\13\2\1\11\3\0\6\2"+
    "\1\12\3\2\1\13\3\0\2\2\1\14\3\2\1\15"+
    "\2\2\1\16\1\17\1\0\2\2\1\0\1\20\1\2"+
    "\1\21\1\2\1\0\1\2\1\22\1\23\1\2\1\24"+
    "\1\25\1\26\4\2\1\27\1\30";

  private static int [] zzUnpackAction() {
    int [] result = new int[88];
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
    "\0\0\0\61\0\142\0\223\0\304\0\61\0\365\0\u0126"+
    "\0\u0157\0\u0188\0\u01b9\0\u01ea\0\u021b\0\u024c\0\u027d\0\u02ae"+
    "\0\u02df\0\u0310\0\61\0\61\0\61\0\61\0\u0341\0\u0372"+
    "\0\u03a3\0\u03d4\0\u0405\0\u0436\0\u0467\0\u0498\0\u04c9\0\u04fa"+
    "\0\u052b\0\u055c\0\u058d\0\u05be\0\u05ef\0\61\0\u0620\0\u0651"+
    "\0\u0682\0\u06b3\0\u06e4\0\u0715\0\u0746\0\u0777\0\u07a8\0\142"+
    "\0\u07d9\0\u080a\0\u083b\0\142\0\u086c\0\u089d\0\u08ce\0\u08ff"+
    "\0\u0930\0\142\0\u0961\0\u0992\0\u09c3\0\142\0\u09f4\0\u0a25"+
    "\0\61\0\61\0\u0a56\0\u0a87\0\u0ab8\0\u0ae9\0\142\0\u0b1a"+
    "\0\142\0\u0b4b\0\u0b7c\0\u0bad\0\142\0\61\0\u0bde\0\142"+
    "\0\61\0\142\0\u0c0f\0\u0c40\0\u0c71\0\u0ca2\0\142\0\142";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[88];
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
    "\1\2\1\3\1\4\1\3\1\5\2\6\1\3\1\7"+
    "\1\2\1\10\1\11\6\3\1\12\5\3\1\13\2\3"+
    "\1\14\1\15\1\16\1\17\2\3\1\20\1\3\1\2"+
    "\1\21\3\3\1\22\3\3\1\23\1\24\1\25\1\26"+
    "\63\0\3\3\3\0\1\3\3\0\30\3\1\0\10\3"+
    "\7\0\1\4\63\0\1\6\53\0\11\27\1\0\20\27"+
    "\1\30\17\27\1\31\6\27\2\0\2\32\11\0\1\32"+
    "\7\0\1\32\1\0\1\32\3\0\2\32\1\0\1\32"+
    "\3\0\1\32\1\0\1\32\6\0\1\32\6\0\3\3"+
    "\3\0\1\3\3\0\1\3\1\33\26\3\1\0\10\3"+
    "\6\0\3\3\3\0\1\3\3\0\10\3\1\34\17\3"+
    "\1\0\10\3\6\0\3\3\3\0\1\3\3\0\16\3"+
    "\1\35\10\3\1\36\1\0\10\3\6\0\3\3\3\0"+
    "\1\3\3\0\10\3\1\37\17\3\1\0\10\3\6\0"+
    "\3\3\3\0\1\3\3\0\16\3\1\40\11\3\1\0"+
    "\10\3\6\0\3\3\3\0\1\3\3\0\14\3\1\41"+
    "\13\3\1\0\10\3\6\0\3\3\3\0\1\3\3\0"+
    "\24\3\1\42\3\3\1\0\10\3\6\0\3\3\3\0"+
    "\1\3\3\0\13\3\1\43\14\3\1\0\10\3\6\0"+
    "\3\3\3\0\1\3\3\0\25\3\1\44\2\3\1\0"+
    "\10\3\6\0\3\3\3\0\1\3\3\0\2\3\1\45"+
    "\25\3\1\0\10\3\5\0\10\27\1\46\60\27\1\46"+
    "\11\27\1\47\46\27\1\46\20\27\1\50\27\27\2\0"+
    "\2\51\11\0\1\51\7\0\1\51\1\0\1\51\3\0"+
    "\2\51\1\0\1\51\3\0\1\51\1\0\1\51\6\0"+
    "\1\51\6\0\3\3\3\0\1\3\3\0\2\3\1\52"+
    "\25\3\1\0\10\3\6\0\3\3\3\0\1\3\3\0"+
    "\11\3\1\53\16\3\1\0\10\3\6\0\3\3\3\0"+
    "\1\3\3\0\17\3\1\54\10\3\1\0\10\3\6\0"+
    "\3\3\3\0\1\3\3\0\11\3\1\55\16\3\1\0"+
    "\10\3\6\0\3\3\3\0\1\3\3\0\7\3\1\56"+
    "\20\3\1\0\10\3\6\0\3\3\3\0\1\3\3\0"+
    "\11\3\1\57\16\3\1\0\10\3\6\0\3\3\3\0"+
    "\1\3\3\0\21\3\1\60\6\3\1\0\10\3\6\0"+
    "\3\3\3\0\1\3\3\0\25\3\1\61\2\3\1\0"+
    "\10\3\6\0\3\3\3\0\1\3\3\0\14\3\1\62"+
    "\13\3\1\0\10\3\6\0\3\3\3\0\1\3\3\0"+
    "\27\3\1\63\1\0\10\3\6\0\3\3\3\0\1\3"+
    "\3\0\30\3\1\0\5\3\1\64\2\3\5\0\10\27"+
    "\1\46\41\27\1\65\16\27\1\46\42\27\1\66\5\27"+
    "\2\0\2\67\11\0\1\67\7\0\1\67\1\0\1\67"+
    "\3\0\2\67\1\0\1\67\3\0\1\67\1\0\1\67"+
    "\6\0\1\67\6\0\3\3\3\0\1\3\3\0\3\3"+
    "\1\70\24\3\1\0\10\3\6\0\3\3\3\0\1\3"+
    "\3\0\12\3\1\71\15\3\1\0\10\3\6\0\3\3"+
    "\3\0\1\3\3\0\10\3\1\72\17\3\1\0\10\3"+
    "\6\0\3\3\3\0\1\3\3\0\27\3\1\73\1\0"+
    "\10\3\6\0\3\3\3\0\1\3\3\0\21\3\1\74"+
    "\6\3\1\0\10\3\6\0\3\3\3\0\1\3\3\0"+
    "\14\3\1\75\13\3\1\0\10\3\6\0\3\3\3\0"+
    "\1\3\3\0\14\3\1\76\13\3\1\0\10\3\6\0"+
    "\3\3\3\0\1\3\3\0\14\3\1\77\13\3\1\0"+
    "\10\3\6\0\3\3\3\0\1\3\3\0\21\3\1\100"+
    "\6\3\1\0\10\3\5\0\10\27\1\101\60\27\1\102"+
    "\50\27\2\0\2\103\11\0\1\103\7\0\1\103\1\0"+
    "\1\103\3\0\2\103\1\0\1\103\3\0\1\103\1\0"+
    "\1\103\6\0\1\103\6\0\3\3\3\0\1\3\3\0"+
    "\4\3\1\104\23\3\1\0\10\3\6\0\3\3\3\0"+
    "\1\3\3\0\13\3\1\105\14\3\1\0\10\3\6\0"+
    "\3\3\3\0\1\3\3\0\30\3\1\106\10\3\6\0"+
    "\3\3\3\0\1\3\3\0\10\3\1\107\17\3\1\0"+
    "\10\3\6\0\3\3\3\0\1\3\3\0\7\3\1\110"+
    "\20\3\1\0\10\3\6\0\3\3\3\0\1\3\3\0"+
    "\7\3\1\111\20\3\1\0\10\3\6\0\3\3\3\0"+
    "\1\3\3\0\13\3\1\112\14\3\1\0\10\3\7\0"+
    "\2\113\11\0\1\113\7\0\1\113\1\0\1\113\3\0"+
    "\2\113\1\0\1\113\3\0\1\113\1\0\1\113\6\0"+
    "\1\113\6\0\3\3\3\0\1\3\3\0\5\3\1\114"+
    "\22\3\1\0\10\3\6\0\3\3\3\0\1\3\3\0"+
    "\14\3\1\115\13\3\1\0\10\3\30\0\1\116\36\0"+
    "\3\3\3\0\1\3\3\0\30\3\1\0\1\3\1\117"+
    "\6\3\6\0\3\3\3\0\1\3\3\0\10\3\1\120"+
    "\17\3\1\0\10\3\7\0\2\121\11\0\1\121\7\0"+
    "\1\121\1\0\1\121\3\0\2\121\1\0\1\121\3\0"+
    "\1\121\1\0\1\121\6\0\1\121\6\0\3\3\3\0"+
    "\1\3\3\0\6\3\1\122\21\3\1\0\10\3\6\0"+
    "\3\3\3\0\1\3\3\0\16\3\1\123\11\3\1\0"+
    "\10\3\6\0\3\3\3\0\1\3\3\0\10\3\1\124"+
    "\17\3\1\0\10\3\6\0\3\3\3\0\1\3\3\0"+
    "\7\3\1\125\20\3\1\0\10\3\6\0\3\3\3\0"+
    "\1\126\3\0\30\3\1\0\10\3\6\0\3\3\3\0"+
    "\1\3\3\0\30\3\1\0\2\3\1\127\1\130\4\3"+
    "\5\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3283];
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
    "\1\0\1\11\3\1\1\11\14\1\4\11\4\0\13\1"+
    "\1\11\3\0\13\1\3\0\11\1\2\11\1\0\2\1"+
    "\1\0\4\1\1\0\2\1\1\11\2\1\1\11\7\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[88];
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
    private CanvasDriver driver;

    public CanvasLexer(java.io.Reader in, CanvasDriver driver) {
        this.zzReader = in;
        this.driver = driver;
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
        Error error = new Error(line, column, "Lexico", "Elemento lexico desconocido: '" + yytext() + "'");
        driver.getErrors().add(error);
    }



  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public CanvasLexer(java.io.Reader in) {
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
    while (i < 186) {
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

    throw new java.lang.Error(message);
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
                                  error(yytext(), yyline+1, yycolumn+1);
            } 
            // fall through
          case 25: break;
          case 2: 
            { printToken("Id: " + yytext()); return symbol(sym.ID, yytext());
            } 
            // fall through
          case 26: break;
          case 3: 
            { printToken(yytext()); return symbol(sym.INT,  Integer.parseInt(yytext()));
            } 
            // fall through
          case 27: break;
          case 4: 
            { /*do nothing*/
            } 
            // fall through
          case 28: break;
          case 5: 
            { printToken("{"); return symbol(sym.CURLYBRACKETO, "{");
            } 
            // fall through
          case 29: break;
          case 6: 
            { printToken("}"); return symbol(sym.CURLYBRACKETC, "}");
            } 
            // fall through
          case 30: break;
          case 7: 
            { printToken(":"); return symbol(sym.COLON, ":");
            } 
            // fall through
          case 31: break;
          case 8: 
            { printToken(","); return symbol(sym.COMMA, ",");
            } 
            // fall through
          case 32: break;
          case 9: 
            { printToken("Name: " + yytext()); return symbol(sym.NAME, yytext());
            } 
            // fall through
          case 33: break;
          case 10: 
            { printToken("Red"); return symbol(sym.RED, "Red");
            } 
            // fall through
          case 34: break;
          case 11: 
            { printToken("HEX"); return symbol(sym.HEX, "HEX");
            } 
            // fall through
          case 35: break;
          case 12: 
            { printToken("tipo"); return symbol(sym.TIPO, "tipo");
            } 
            // fall through
          case 36: break;
          case 13: 
            { printToken("Blue"); return symbol(sym.BLUE, "Blue");
            } 
            // fall through
          case 37: break;
          case 14: 
            { printToken("png"); return symbol(sym.PNG, "\"png\"");
            } 
            // fall through
          case 38: break;
          case 15: 
            { printToken("gif"); return symbol(sym.GIF, "\"gif\"");
            } 
            // fall through
          case 39: break;
          case 16: 
            { printToken("FONDO"); return symbol(sym.FONDO, "Fondo");
            } 
            // fall through
          case 40: break;
          case 17: 
            { printToken("Green"); return symbol(sym.GREEN, "Green");
            } 
            // fall through
          case 41: break;
          case 18: 
            { printToken("nombre"); return symbol(sym.NOMBRE, "nombre");
            } 
            // fall through
          case 42: break;
          case 19: 
            { printToken("tamaño"); return symbol(sym.SIZE, "tamaño");
            } 
            // fall through
          case 43: break;
          case 20: 
            { printToken("cuadro"); return symbol(sym.CUADRO, "cuadro");
            } 
            // fall through
          case 44: break;
          case 21: 
            { printToken(yytext()); return symbol(sym.HEXCODE, yytext());
            } 
            // fall through
          case 45: break;
          case 22: 
            { printToken("LIENZOS"); return symbol(sym.LIENZOS, "LIENZOS");
            } 
            // fall through
          case 46: break;
          case 23: 
            { printToken("dimension_x"); return symbol(sym.DIMENSIONX, "dimension_x");
            } 
            // fall through
          case 47: break;
          case 24: 
            { printToken("dimension_y"); return symbol(sym.DIMENSIONY, "dimension_y");
            } 
            // fall through
          case 48: break;
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
      System.out.println("Usage : java CanvasLexer [ --encoding <name> ] <inputfile(s)>");
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
        CanvasLexer scanner = null;
        try {
          java.io.FileInputStream stream = new java.io.FileInputStream(argv[i]);
          java.io.Reader reader = new java.io.InputStreamReader(stream, encodingName);
          scanner = new CanvasLexer(reader);
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