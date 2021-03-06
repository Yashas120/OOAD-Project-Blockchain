package transaction;
import java.io.*;
import java.math.BigInteger;
import java.nio.*;
import java.util.*;
abstract class helper {
  protected static final char[] HEX_ARRAY = "0123456789abcdef".toCharArray();

  public static String bytesToHex(byte[] in) {
    final StringBuilder builder = new StringBuilder();
    for(byte b : in) {
        builder.append(String.format("%02x", 0xFF & b));
    }
    return builder.toString();
  }

  static protected byte[] reverse(byte[] array) {
    byte[] arr = new byte[array.length];
    for(int i=0; i<array.length; i++){
        arr[i] = array[array.length-i-1];
    }
    return arr;
}

  static protected byte[] hexStringToByteArray(String s) {
    int len = s.length();
    byte[] data = new byte[len / 2];
    for (int i = 0; i < len; i += 2) {
        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                             + Character.digit(s.charAt(i+1), 16));
    }
    return data;
}

  static protected long bytesToLongLittle(byte []arr){
    byte []conv = new byte[8];
    conv[0] = arr[0];
    conv[1] = arr[1];
    conv[2] = arr[2];
    conv[3] = arr[3];
    return ByteBuffer.wrap(conv).getLong();
}
  public static Map<Byte,String> OCN(){ 
  Map<Byte, String> OP_CODE_NAMES = new HashMap<>();

  OP_CODE_NAMES.put((byte) 0,"OP_0");
  OP_CODE_NAMES.put((byte) 76,"OP_PUSHDATA1");
  OP_CODE_NAMES.put((byte) 77,"OP_PUSHDATA2");
  OP_CODE_NAMES.put((byte) 78,"OP_PUSHDATA4");
  OP_CODE_NAMES.put((byte) 79,"OP_1NEGATE");
  OP_CODE_NAMES.put((byte) 81,"OP_1");
  OP_CODE_NAMES.put((byte) 82,"OP_2");
  OP_CODE_NAMES.put((byte) 83,"OP_3");
  OP_CODE_NAMES.put((byte) 84,"OP_4");
  OP_CODE_NAMES.put((byte) 85,"OP_5");
  OP_CODE_NAMES.put((byte) 86,"OP_6");
  OP_CODE_NAMES.put((byte) 87,"OP_7");
  OP_CODE_NAMES.put((byte) 88,"OP_8");
  OP_CODE_NAMES.put((byte) 89,"OP_9");
  OP_CODE_NAMES.put((byte) 90,"OP_10");
  OP_CODE_NAMES.put((byte) 91,"OP_11");
  OP_CODE_NAMES.put((byte) 92,"OP_12");
  OP_CODE_NAMES.put((byte) 93,"OP_13");
  OP_CODE_NAMES.put((byte) 94,"OP_14");
  OP_CODE_NAMES.put((byte) 95,"OP_15");
  OP_CODE_NAMES.put((byte) 96,"OP_16");
  OP_CODE_NAMES.put((byte) 97,"OP_NOP");
  OP_CODE_NAMES.put((byte) 99,"OP_IF");
  OP_CODE_NAMES.put((byte) 100, "OP_NOTIF");
  OP_CODE_NAMES.put((byte) 103, "OP_ELSE");
  OP_CODE_NAMES.put((byte) 104, "OP_ENDIF");
  OP_CODE_NAMES.put((byte) 105 ,"OP_VERIFY");
  OP_CODE_NAMES.put((byte) 106 ,"OP_RETURN");
  OP_CODE_NAMES.put((byte) 107 ,"OP_TOALTSTACK");
  OP_CODE_NAMES.put((byte) 108 ,"OP_FROMALTSTACK");
  OP_CODE_NAMES.put((byte) 109 ,"OP_2DROP");
  OP_CODE_NAMES.put((byte) 110 ,"OP_2DUP");
  OP_CODE_NAMES.put((byte) 111 ,"OP_3DUP");
  OP_CODE_NAMES.put((byte) 112 ,"OP_2OVER");
  OP_CODE_NAMES.put((byte) 113 ,"OP_2ROT");
  OP_CODE_NAMES.put((byte) 114 ,"OP_2SWAP");
  OP_CODE_NAMES.put((byte) 115 ,"OP_IFDUP");
  OP_CODE_NAMES.put((byte) 116 ,"OP_DEPTH");
  OP_CODE_NAMES.put((byte) 117 ,"OP_DROP");
  OP_CODE_NAMES.put((byte) 118 ,"OP_DUP");
  OP_CODE_NAMES.put((byte) 119 ,"OP_NIP");
  OP_CODE_NAMES.put((byte) 120 ,"OP_OVER");
  OP_CODE_NAMES.put((byte) 121 ,"OP_PICK");
  OP_CODE_NAMES.put((byte) 122 ,"OP_ROLL");
  OP_CODE_NAMES.put((byte) 123 ,"OP_ROT");
  OP_CODE_NAMES.put((byte) 124 ,"OP_SWAP");
  OP_CODE_NAMES.put((byte) 125 ,"OP_TUCK");
  OP_CODE_NAMES.put((byte) 130 ,"OP_SIZE");
  OP_CODE_NAMES.put((byte) 135 ,"OP_EQUAL");
  OP_CODE_NAMES.put((byte) 136 ,"OP_EQUALVERIFY");
  OP_CODE_NAMES.put((byte) 139 ,"OP_1ADD");
  OP_CODE_NAMES.put((byte) 140 ,"OP_1SUB");
  OP_CODE_NAMES.put((byte) 143 ,"OP_NEGATE");
  OP_CODE_NAMES.put((byte) 144 ,"OP_ABS");
  OP_CODE_NAMES.put((byte) 145 ,"OP_NOT");
  OP_CODE_NAMES.put((byte) 146 ,"OP_0NOTEQUAL");
  OP_CODE_NAMES.put((byte) 147 ,"OP_ADD");
  OP_CODE_NAMES.put((byte) 148 ,"OP_SUB");
  OP_CODE_NAMES.put((byte) 154 ,"OP_BOOLAND");
  OP_CODE_NAMES.put((byte) 155 ,"OP_BOOLOR");
  OP_CODE_NAMES.put((byte) 156 ,"OP_NUMEQUAL");
  OP_CODE_NAMES.put((byte) 157 ,"OP_NUMEQUALVERIFY");
  OP_CODE_NAMES.put((byte) 158 ,"OP_NUMNOTEQUAL");
  OP_CODE_NAMES.put((byte) 159 ,"OP_LESSTHAN");
  OP_CODE_NAMES.put((byte) 160 ,"OP_GREATERTHAN");
  OP_CODE_NAMES.put((byte) 161 ,"OP_LESSTHANOREQUAL");
  OP_CODE_NAMES.put((byte) 162 ,"OP_GREATERTHANOREQUAL");
  OP_CODE_NAMES.put((byte) 163 ,"OP_MIN");
  OP_CODE_NAMES.put((byte) 164 ,"OP_MAX");
  OP_CODE_NAMES.put((byte) 165 ,"OP_WITHIN");
  OP_CODE_NAMES.put((byte) 166 ,"OP_RIPEMD160");
  OP_CODE_NAMES.put((byte) 167 ,"OP_SHA1");
  OP_CODE_NAMES.put((byte) 168 ,"OP_SHA256");
  OP_CODE_NAMES.put((byte) 169 ,"OP_HASH160");
  OP_CODE_NAMES.put((byte) 170 ,"OP_HASH256");
  OP_CODE_NAMES.put((byte) 171 ,"OP_CODESEPARATOR");
  OP_CODE_NAMES.put((byte) 172 ,"OP_CHECKSIG");
  OP_CODE_NAMES.put((byte) 173 ,"OP_CHECKSIGVERIFY");
  OP_CODE_NAMES.put((byte) 174 ,"OP_CHECKMULTISIG");
  OP_CODE_NAMES.put((byte) 175 ,"OP_CHECKMULTISIGVERIFY");
  OP_CODE_NAMES.put((byte) 176 ,"OP_NOP1");
  OP_CODE_NAMES.put((byte) 177 ,"OP_CHECKLOCKTIMEVERIFY");
  OP_CODE_NAMES.put((byte) 178 ,"OP_CHECKSEQUENCEVERIFY");
  OP_CODE_NAMES.put((byte) 179 ,"OP_NOP4");
  OP_CODE_NAMES.put((byte) 180 ,"OP_NOP5");
  OP_CODE_NAMES.put((byte) 181 ,"OP_NOP6");
  OP_CODE_NAMES.put((byte) 182 ,"OP_NOP7");
  OP_CODE_NAMES.put((byte) 183 ,"OP_NOP8");
  OP_CODE_NAMES.put((byte) 184 ,"OP_NOP9");
  OP_CODE_NAMES.put((byte) 185 ,"OP_NOP10");

  return OP_CODE_NAMES;
}
}
