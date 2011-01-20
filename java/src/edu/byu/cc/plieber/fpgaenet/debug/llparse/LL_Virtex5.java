/* Generated By:JavaCC: Do not edit this line. LL_Virtex5.java */
/*
@LICENSE@
*/
package edu.byu.cc.plieber.fpgaenet.debug.llparse;
import java.lang.*;
import java.util.*;

/**
 * The Xilinx Logical Allocation file (.ll file) parser for Virtex2
 * FPGAs. The parser fills two <code>Hashtable</code> objects with the
 * readback bitstream information for state elements in the Virtex5
 * design.  One <code>Hashtable</code> is filled with RAM bitstream
 * information keyed on physical location (block name) while the
 * second holds the bitstream information for flip-flops keyed on
 * physical location (block name).  The grammar is not published but
 * was developed from looking at the file format.
 *
 * @author Paul Graham
 * @author Peter Lieber */
public class LL_Virtex5 implements LL_Virtex5Constants {

  /** 
   * A <code>HashTable</code> to allow quick access to {@link
   * RAMGroup} objects based on block name and RAM type. The
   * <code>RAMGroup</code> objects contain {@link RAMRBEntry} objects
   * which hold the actual bitstream offsets.  */
  Hashtable<String, RAMGroup > RAMGroupHash;

  /** 
   * A <code>Hashtable</code> of {@link LatchRBEntry} objects to allow
   * quick access based on block name and latch type.  The
   * <code>LatchRBEntry</code> is used for flip-flops and stores
   * bitstream offset information. */
  Hashtable<String, LatchRBEntry > NetHashBlock;

  /** The number of nets associated with latches in the .ll file */
  int netCount;

  /** The number of RAM entries in the .ll file */
  int ramCount;

  /** 
   * Indicates whether the LL file provides absolute offsets. First
   * needed with the Xilinx 4.1 ISE tools*/
  boolean absOffsets;

  /** 
   * Instances and initializes the parser and parses the input from
   * <code>System.in</code>
   *
   * @param args Command line arguments (ignored by the method)
   * */
  public static void main(String args[]) throws ParseException {
    LL_Virtex5 parser = new LL_Virtex5(System.in);
    parser.initTables();
    parser.parseLL();
  }

  /**
   * Initializes the <code>Hashtables</code> and counts.  */
  public void initTables() {
    RAMGroupHash = new Hashtable<String, RAMGroup >();
    NetHashBlock = new Hashtable<String, LatchRBEntry >();
    netCount = 0;
    ramCount = 0;
    absOffsets = false;
  }

  /**
   * Returns a reference to the <code>RAMGroupHash</code>, which holds
   * a {@link RAMGroup} object for each RAM in the .ll file keyed on
   * the location of the RAM and the RAM type (F, G, M, or B).
   *
   * @return Reference to <code>RAMGroupHash</code> */
  public Hashtable<String, RAMGroup > getRAMGroupHash() {
    return RAMGroupHash;
  }

  /**
   * Returning a reference to the <code>NetHashBlock</code>, which
   * holds a {@link LatchRBEntry} for each flip-flop in the .ll file
   * keyed on the location and the latch type (XQ, YQ, etc.)
   *
   * @return Reference to <code>NetHashBlock</code> */
  public Hashtable<String, LatchRBEntry > getNetHashBlock() {
    return NetHashBlock;
  }

  /**
   * Returns true if the LL file provides absolute offsets and false
   * otherwise.  Absolute readback bitstream offsets started appearing
   * in the Xilinx ISE 4.1i series of tools.
   *
   * @return <code>true</code> if absolute offsets are provide,
   * <code>false</code> otherwise.  */
  public boolean hasAbsoluteOffsets() {
    return absOffsets;
  }

/**
 * Defines the various flip-flop types and returns the type as
 * a <code>String</code>.
 *
 * @return <code>String</code> for flip-flop type. */
  final public String LatchType() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case AQ:
      jj_consume_token(AQ);
       {if (true) return token.toString();}
      break;
    case BQ:
      jj_consume_token(BQ);
        {if (true) return token.toString();}
      break;
    case CQ:
      jj_consume_token(CQ);
        {if (true) return token.toString();}
      break;
    case DQ:
      jj_consume_token(DQ);
        {if (true) return token.toString();}
      break;
    case Q1:
      jj_consume_token(Q1);
        {if (true) return token.toString();}
      break;
    case Q2:
      jj_consume_token(Q2);
        {if (true) return token.toString();}
      break;
    case I:
      jj_consume_token(I);
       {if (true) return token.toString();}
      break;
    case O:
      jj_consume_token(O);
       {if (true) return token.toString();}
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

/**
 * Initiates the parsing of an <code>.ll</code> file and prints out
 * statistics about the number of flip-flops (latches) and RAMs it
 * found.*/
  final public void parseLL() throws ParseException {
    Revision();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BIT:
      case INFO:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BIT:
        BitStreamEntry();
        break;
      case INFO:
        InfoEntry();
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    jj_consume_token(0);
  System.out.println("Total Block/Latch Entries: "+
                     Integer.toString(NetHashBlock.size())+ " Total Nets:" +
                     Integer.toString(netCount));
  System.out.println("Number of RAMGroup Entries: "+
                     Integer.toString(RAMGroupHash.size())+
                     " Total RAM entries:" + Integer.toString(ramCount));
  System.out.flush();
  }

/**
 * Parses the revision information for the .ll file.
 */
  final public void Revision() throws ParseException {
    jj_consume_token(REVISION);
    jj_consume_token(NUM);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 44:
      jj_consume_token(44);
      break;
    case 45:
      jj_consume_token(45);
      break;
    case 46:
      jj_consume_token(46);
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/**
 * Parses the entire clause having the type of the flip-flop and
 * returns the flip-flop type as a String.  
 *
 * @return Flip-flop type as <code>String</code>. */
  final public String Latch() throws ParseException {
  String latchtype;
    jj_consume_token(LATCH);
    jj_consume_token(EQUAL);
    latchtype = LatchType();
                                         {if (true) return latchtype;}
    throw new Error("Missing return statement in function");
  }

/**
 * Parses the net names associated with latches and stores a
 * <code>LatchRBEntry</code> object in the <code>NetHashBlock
 * Hashtable</code>.  The method handles both angle brackets ("<>")
 * and square brackets ("[]") for net names.  In some strange
 * circumstances, it was necessary to handle names which extended
 * beyond the array naming construct (in other words, there was still
 * part of the name after the last "]" or ">").  In these cases, the
 * names are considered atomic (not multi-bit), so the index variable
 * is reset to "-1".
 *
 * @param offset The first offset provided by the LL file for this
 *               flip-flop; it is actually a junk bit in the readback
 *               bitstream.
 *
 * @param frame The frame number for this flip-flops readback data
 *              provided by the LL file.
 *
 * @param frameOffset The offset within the frame for this flip-flop's
 *                    readback data provided by the LL file.
 *
 * @param block The block's name and location. 
 *
 * @param latchType The type of the flip-flop.
 **/
  final public void NetName(int offset, int frame, int frameOffset, String block, String latchType) throws ParseException {
  String netname;
  int index=-1;
  boolean extended=false;
  LatchRBEntry lrbe;
    jj_consume_token(ID);
         netname = token.toString();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LANGLE:
    case LBRACKET:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LANGLE:
        jj_consume_token(LANGLE);
        jj_consume_token(NUM);
          index = Integer.parseInt(token.toString());
        jj_consume_token(RANGLE);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case NETEXT:
          jj_consume_token(NETEXT);
     netname = new String(netname+"<"+Integer.toString(index)+">"+token.toString());
     index = -1;
     extended = true;
          break;
        default:
          jj_la1[4] = jj_gen;
          ;
        }
        break;
      case LBRACKET:
        jj_consume_token(LBRACKET);
        jj_consume_token(NUM);
          index = Integer.parseInt(token.toString());
        jj_consume_token(RBRACKET);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case NETEXT:
          jj_consume_token(NETEXT);
     netname = new String(netname+"["+Integer.toString(index)+"]"+token.toString());
     index = -1;
     extended = true;
          break;
        default:
          jj_la1[5] = jj_gen;
          ;
        }
        break;
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[7] = jj_gen;
      ;
    }
        if(!block.equals("DUMMY")) {
          lrbe = new LatchRBEntry(offset,frame,frameOffset,block,latchType,netname,index);
          netCount++;
          NetHashBlock.put(block+latchType, lrbe);
        }
  }

/**
 * Parses the entire "Net=..." clause.
 *
 * @param offset The first offset provided by the LL file for this
 *               flip-flop; it is actually a junk bit in the readback
 *               bitstream.
 *
 * @param frame The frame number for this flip-flops readback data
 *              provided by the LL file.
 *
 * @param frameOffset The offset within the frame for this flip-flop's
 *                    readback data provided by the LL file.
 *
 * @param block The block's name and location. 
 *
 * @param latchType The type of the flip-flop.
 */
  final public void Net(int offset, int frame, int frameOffset, String block, String latchType) throws ParseException {
    jj_consume_token(NET);
    jj_consume_token(EQUAL);
    NetName(offset,frame,frameOffset,block,latchType);
  }

/**
 * Parses the "Ram=..." clauses of the RAM LL entries for lut rams and enters the
 * data into the <code>RAMGroupHash</code>. Since a certain RAM may
 * already have a <code>RAMGroup</code> entry in the
 * <code>RAMGroupHash</code>, the method performs a lookup first to
 * see if the RAM's <code>RAMGroup</code> entry exists.  If the entry
 * exists, the method adds a <code>RAMRBEntry</code> to the
 * <code>RAMGroup</code> which was found.  Otherwise, the method
 * creates a new <code>RAMGroup</code> and adds an
 * <code>RAMRBEntry</code> to it. This method handles both LUT RAMs
 * and BlockRAMs.
 *
 * @param offset The first offset provided by the LL file for this
 *               flip-flop; it is actually a junk bit in the readback
 *               bitstream.
 *
 * @param frame The frame number for this flip-flops readback data
 *              provided by the LL file.
 *
 * @param frameOffset The offset within the frame for this flip-flop's
 *                    readback data provided by the LL file.
 *
 * @param block The block's name and location.  */
  final public void SliceRam(int offset, int frame, int frameOffset, String block) throws ParseException {
  String lutType;
  int address;
  RAMGroup rg;
  RAMRBEntry rrb;
  String key;
    jj_consume_token(RAM);
    jj_consume_token(EQUAL);
    jj_consume_token(LUT);
         lutType = token.toString();
    jj_consume_token(COLON);
    jj_consume_token(NUM);
    try {
      address = Integer.parseInt(token.toString());
      rrb = new RAMRBEntry(offset,frame,frameOffset,block,lutType,address);
      ramCount++;
      key = new String(block+"."+lutType);
      rg = (RAMGroup)RAMGroupHash.get(key);
      if(rg == null) {
        RAMGroupHash.put(key,new RAMGroup(rrb));
      }
      else {
        rg.addRAMEntry(rrb);
      }
    }
    catch (RAMTypeException rte) {
      System.out.println("Caught Exception: " + rte.toString());
      System.out.println("Wrong RAM Type: Are you using the proper part type? (Virtex5)");
      rte.printStackTrace();
    }
  }

/**
 * Parses the "Ram=..." clauses of the RAM LL entries for BRAMs and enters the
 * data into the <code>RAMGroupHash</code>. Since a certain RAM may
 * already have a <code>RAMGroup</code> entry in the
 * <code>RAMGroupHash</code>, the method performs a lookup first to
 * see if the RAM's <code>RAMGroup</code> entry exists.  If the entry
 * exists, the method adds a <code>RAMRBEntry</code> to the
 * <code>RAMGroup</code> which was found.  Otherwise, the method
 * creates a new <code>RAMGroup</code> and adds an
 * <code>RAMRBEntry</code> to it. This method handles both LUT RAMs
 * and BlockRAMs.
 *
 * @param offset The first offset provided by the LL file for this
 *               flip-flop; it is actually a junk bit in the readback
 *               bitstream.
 *
 * @param frame The frame number for this flip-flops readback data
 *              provided by the LL file.
 *
 * @param frameOffset The offset within the frame for this flip-flop's
 *                    readback data provided by the LL file.
 *
 * @param block The block's name and location.  */
  final public void BRam(int offset, int frame, int frameOffset, String block) throws ParseException {
  String lutType;
  int address;
  RAMGroup rg;
  RAMRBEntry rrb;
  String key;
    jj_consume_token(RAM);
    jj_consume_token(EQUAL);
    jj_consume_token(LUT);
         lutType = token.toString();
    jj_consume_token(COLON);
    jj_consume_token(ID);
    try {
      String bitAddress = token.toString();
      // We need to skip the PARBIT prefix used for block ram parity bits
      if( bitAddress.charAt(0) == 'P' )
        address = Integer.parseInt(bitAddress.substring(6));
      // We need to skip the BIT prefix used for block ram data bits
      else
        address = Integer.parseInt(bitAddress.substring(3));
      rrb = new RAMRBEntry(offset,frame,frameOffset,block,lutType,address);
      ramCount++;
      key = new String(block+"."+lutType);
      rg = (RAMGroup)RAMGroupHash.get(key);
      if(rg == null) {
        RAMGroupHash.put(key,new RAMGroup(rrb));
      }
      else {
        rg.addRAMEntry(rrb);
      }
    }
    catch (RAMTypeException rte) {
      System.out.println("Caught Exception: " + rte.toString());
      System.out.println("Wrong RAM Type: Are you using the proper part type? (Virtex2, XC4K, etc.)");
      rte.printStackTrace();
    }
  }

/**
 * Parses "Rom=..." entries, but doesn't do anything with them.
 */
  final public void Rom() throws ParseException {
    jj_consume_token(ROM);
    jj_consume_token(EQUAL);
    jj_consume_token(LUT);
    jj_consume_token(COLON);
    jj_consume_token(NUM);
  }

/**
 * Parses "YES/NO" clauses.
 */
  final public void YesNo() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case YES:
      jj_consume_token(YES);
      break;
    case NO:
      jj_consume_token(NO);
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/**
 * Parses "COMPARE=..." clauses, which are otherwise ignored.
 */
  final public void Compare() throws ParseException {
    jj_consume_token(COMPARE);
    jj_consume_token(EQUAL);
    YesNo();
  }

/**
 * Parses the "attributes" of a state bit in the readback bitstream,
 * which define whether it belongs to a flip-flop, a RAM, or a ROM and
 * other related information.  This is really the core of the parsing work.
 *
 * @param offset The first offset provided by the LL file for this
 *               flip-flop; it is actually a junk bit in the readback
 *               bitstream.
 *
 * @param frame The frame number for this flip-flops readback data
 *              provided by the LL file.
 *
 * @param frameOffset The offset within the frame for this flip-flop's
 *                    readback data provided by the LL file.
 *
 * @param block The block's name and location.  */
  final public void SliceAttributes(int offset, int frame, int frameOffset, String block) throws ParseException {
  String latchType;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LATCH:
      latchType = Latch();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NET:
        Net(offset, frame, frameOffset, block, latchType);
        break;
      default:
        jj_la1[9] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMPARE:
        Compare();
        break;
      default:
        jj_la1[10] = jj_gen;
        ;
      }
      break;
    case RAM:
      SliceRam(offset,frame,frameOffset,block);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMPARE:
        Compare();
        break;
      default:
        jj_la1[11] = jj_gen;
        ;
      }
      break;
    case ROM:
      Rom();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMPARE:
        Compare();
        break;
      default:
        jj_la1[12] = jj_gen;
        ;
      }
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/**
 * Parses the "attributes" of a state bit in the readback bitstream,
 * which define whether it belongs to a flip-flop, a RAM, or a ROM and
 * other related information.  This is really the core of the parsing work.
 *
 * @param offset The first offset provided by the LL file for this
 *               flip-flop; it is actually a junk bit in the readback
 *               bitstream.
 *
 * @param frame The frame number for this flip-flops readback data
 *              provided by the LL file.
 *
 * @param frameOffset The offset within the frame for this flip-flop's
 *                    readback data provided by the LL file.
 *
 * @param block The block's name and location.  */
  final public void PinAttributes(int offset, int frame, int frameOffset, String block) throws ParseException {
  String latchType;
    latchType = Latch();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NET:
      Net(offset, frame, frameOffset, block, latchType);
      break;
    default:
      jj_la1[14] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case COMPARE:
      Compare();
      break;
    default:
      jj_la1[15] = jj_gen;
      ;
    }
  }

/**
 * Parses the "attributes" of a state bit in the readback bitstream,
 * which define whether it belongs to a flip-flop, a RAM, or a ROM and
 * other related information.  This is really the core of the parsing work.
 *
 * @param offset The first offset provided by the LL file for this
 *               flip-flop; it is actually a junk bit in the readback
 *               bitstream.
 *
 * @param frame The frame number for this flip-flops readback data
 *              provided by the LL file.
 *
 * @param frameOffset The offset within the frame for this flip-flop's
 *                    readback data provided by the LL file.
 *
 * @param block The block's name and location.  */
  final public void BramAttributes(int offset, int frame, int frameOffset, String block) throws ParseException {
    BRam(offset,frame,frameOffset,block);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case COMPARE:
      Compare();
      break;
    default:
      jj_la1[16] = jj_gen;
      ;
    }
  }

/**
 * Parses the information regarding location of the IOB/SLICE/BLOCKRAM
 * and returns the information as a <code>String</code>. 
 *
 * @return The Virtex2 block location string (for example, "A21",
 *         "CLB_R8C55", "RAMB4_R7C0").
 **/
  final public String Block(int offset, int frame, int frameOffset) throws ParseException {
  String block;
    jj_consume_token(BLOCK);
    jj_consume_token(EQUAL);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SLICEBLOCK:
      jj_consume_token(SLICEBLOCK);
   block = token.toString();
      SliceAttributes(offset,frame,frameOffset,block);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 44:
        jj_consume_token(44);
        break;
      case 45:
        jj_consume_token(45);
        break;
      case 46:
        jj_consume_token(46);
        break;
      default:
        jj_la1[17] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    case BRAMBLOCK:
      jj_consume_token(BRAMBLOCK);
         block = token.toString();
      BramAttributes(offset,frame,frameOffset,block);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 44:
        jj_consume_token(44);
        break;
      case 45:
        jj_consume_token(45);
        break;
      case 46:
        jj_consume_token(46);
        break;
      default:
        jj_la1[18] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    case GTPBLOCK:
    case DCMBLOCK:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case GTPBLOCK:
        jj_consume_token(GTPBLOCK);
        break;
      case DCMBLOCK:
        jj_consume_token(DCMBLOCK);
        break;
      default:
        jj_la1[19] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
         block = token.toString();
      jj_consume_token(TYPE);
      jj_consume_token(EQUAL);
      jj_consume_token(ID);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 44:
        jj_consume_token(44);
        break;
      case 45:
        jj_consume_token(45);
        break;
      case 46:
        jj_consume_token(46);
        break;
      default:
        jj_la1[20] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    case PINBLOCK:
      jj_consume_token(PINBLOCK);
         block = token.toString();
      PinAttributes(offset,frame,frameOffset,block);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 44:
        jj_consume_token(44);
        break;
      case 45:
        jj_consume_token(45);
        break;
      case 46:
        jj_consume_token(46);
        break;
      default:
        jj_la1[21] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
   {if (true) return block;}
    throw new Error("Missing return statement in function");
  }

/**
 * Parses an entire readback bitstream location entry for a state
 * element. */
  final public void BitStreamEntry() throws ParseException {
  int offset,frame,frameOffset;
  String block;
    jj_consume_token(BIT);
    jj_consume_token(NUM);
               offset = Integer.parseInt(token.toString());
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUM:
      jj_consume_token(NUM);
          frame = Integer.parseInt(token.toString());
      break;
    case HEXNUM:
      jj_consume_token(HEXNUM);
             frame = Integer.decode(token.toString()).intValue(); absOffsets=true;
      break;
    default:
      jj_la1[23] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(NUM);
         frameOffset = Integer.parseInt(token.toString());
    block = Block(offset, frame, frameOffset);
  }

/**
 * Parses the value of any the informational entries in the LL
 * file. The information is ignored. */
  final public void InfoValue() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      jj_consume_token(ID);
      break;
    case NUM:
      jj_consume_token(NUM);
      break;
    default:
      jj_la1[24] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/**
 * Parses any entries in the LL file which do not directly associate
 * state elements with readback bitstream locations.  These entries
 * describe some of the bitstream generation options used for the
 * bitstream. */
  final public void InfoEntry() throws ParseException {
    jj_consume_token(INFO);
    jj_consume_token(ID);
    jj_consume_token(EQUAL);
    InfoValue();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 44:
      jj_consume_token(44);
      break;
    case 45:
      jj_consume_token(45);
      break;
    case 46:
      jj_consume_token(46);
      break;
    default:
      jj_la1[25] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  /** Generated Token Manager. */
  public LL_Virtex5TokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[26];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x1fe0000,0x0,0x0,0x0,0x0,0x0,0x28000000,0x28000000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0xc000,0x0,0x0,0x1f000,0xc0,0x40,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x201,0x201,0x7000,0x800,0x800,0x0,0x0,0xc0,0x20,0x100,0x100,0x100,0x1c,0x20,0x100,0x100,0x7000,0x7000,0x0,0x7000,0x7000,0x0,0x0,0x400,0x7000,};
   }

  /** Constructor with InputStream. */
  public LL_Virtex5(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public LL_Virtex5(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new LL_Virtex5TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public LL_Virtex5(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new LL_Virtex5TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public LL_Virtex5(LL_Virtex5TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(LL_Virtex5TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[47];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 26; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 47; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}