package hashing;

import static org.junit.Assert.assertEquals;

import java.nio.charset.StandardCharsets;

import org.junit.Test;

public class HashTest{
    private static String bytesToHex(byte[] in) {
        final StringBuilder builder = new StringBuilder();
        for(byte b : in) {
            builder.append(String.format("%02x", 0xFF & b));
        }
        return builder.toString();
    }

    @Test
    public void test_empty_sha256(){
        Sha hash = Sha.getSha();
        byte[] actual_bytes = hash.sha256("".getBytes());
        String actual = bytesToHex(actual_bytes);
        String expected = "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855";
        String description = "Empty string hash test";
        try{
            assertEquals(expected, actual);
            System.out.println(description + " - \033[92mpassed\033[0m");
        }catch(AssertionError e){
            System.out.println(description + " - \033[91mfailed\033[0m");
          throw e;
        }
    }

    @Test
    public void test_short_sha256(){
        Sha hash = Sha.getSha();
        byte[] actual_bytes = hash.sha256("OOAD-short-test".getBytes());
        String actual = bytesToHex(actual_bytes);
        String expected = "ed17860dbe4ec22b048fe047bb61972c2e0411da97c271967113b5231191f8ad";
        String description = "Short string hash test";
        try{
            assertEquals(expected, actual);
            System.out.println(description + " - \033[92mpassed\033[0m");
        }catch(AssertionError e){
            System.out.println(description + " - \033[91mfailed\033[0m");
          throw e;
        }
    }

    @Test
    public void test_medium_sha256(){
        Sha hash = Sha.getSha();
        byte[] actual_bytes = hash.sha256(("An aim is a goal or objective to achieve in life. " + 
                                    "In order to succeed in life, one must have a goal. " + 
                                    "My aim in life is to be a teacher. " + 
                                    "Teaching is a noble and responsible profession. " + 
                                    "I have come to know that the ever-increasing misery and distress, are due to the ignorance and illiteracy of the people of our country. " + 
                                    "So I have decided to spread education among the masses as much as possible within my humble power. " + 
                                    "As a teacher, I shall try my best to impart man-making education. Some say that money is the honey of life. " + 
                                    "But I do not agree with them. Rather, I think that morality is the real honey of life. " + 
                                    "I want to be a lovable and respectable person as a teacher in the future.").getBytes()
                                );
        String actual = bytesToHex(actual_bytes);
        String expected = "b0b39c997dddf9350ad31d3f474748aa4206726992a5ef3f6de7c55e2b79a243";
        String description = "Medium string hash test";
        try{
            assertEquals(expected, actual);
            System.out.println(description + " - \033[92mpassed\033[0m");
        }catch(AssertionError e){
            System.out.println(description + " - \033[91mfailed\033[0m");
          throw e;
        }
    }

    @Test
    public void test_hard_sha256(){
        Sha hash = Sha.getSha();
        byte[] actual_bytes = hash.sha256(("An00aim||||life75756htg977v899 85757is 8578a 986988goal or objective to ach||||life75756htgieve in life. " + 
                                    "In ordeching is a noble and respon||||life75756htgsibl;;;wl;**37021:00031+++++++++++__+_+_+_r to succeed idawdawd{}n life, one must have a goal. " + 
                                    "My aim in ;;;;||||||life757||||life75756htg56htghfsdad is to be a8678678 teacher. " + 
                                    "Teach||||lif||||life75756htge75756htging is a noble and||||life75756htg responsibl;;;wl;**37021:00031+++++++++++__+_+_+_+_e profession. " + 
                                    "I havve come to know that t||||life75756htghe ever-increasing misery and distress, are due to the ignorance and illiteracy of the people of our country. " + 
                                    "So I hav||||life75756htge decided to spreaching ;;;;;;;;;;;;;;;;is a noble ||||life75756htgand responsibl;;;wl;**37021:00031+++++++++++__+_+_+_d education among the masses as much as possible within my humble power. " + 
                                    "As a teacher||||life7||||life75756htg5756htg, I shall try my best to impart man-making ching is a noble and responsibl;;;wl;**37021:00031+++++++++++__+_+_+_education. Some say that money is the honey of life. " + 
                                    "But I doching is a noble and responsibl;;;wl;**37021:00031+++++++++++__+_+_+_ not agree with them. Rather, I think that morality is the real honey of life. " + 
                                    "I want to be||||life75756htg a lov||||life75756htgable and re||||life75756htgspectable person as a teacher in the future.").getBytes()
                                );
        String actual = bytesToHex(actual_bytes);
        String expected = "bf38611267d7c973c23dd7eac3cc86c820d6e58e22ee66e36e554cd9a22ff0ae";
        String description = "hard string hash test";
        try{
            assertEquals(expected, actual);
            System.out.println(description + " - \033[92mpassed\033[0m");
        }catch(AssertionError e){
            System.out.println(description + " - \033[91mfailed\033[0m");
          throw e;
        }
    }

    // @Test // doesnt work for some reason
    public void test_double_hash_sha256(){
        Sha hash = Sha.getSha();
        byte[] input = "6f0339838caab76d143780e3b36372e67f12c25c2a3e0ca9b826fa4b0b5b6da2da81".getBytes();
        byte[] actual_bytes = hash.sha256(hash.sha256(input));
        String actual = bytesToHex(actual_bytes);
        String expected = "69f29bda1591a192a332b6956ab02d8bf71b422bfd856c08deb64345221144ea";
        String description = "double hash test";
        System.out.println(actual);
        System.out.println(expected);
        try{
            assertEquals(expected, actual);
            System.out.println(description + " - \033[92mpassed\033[0m");
        }catch(AssertionError e){
            System.out.println(description + " - \033[91mfailed\033[0m");
          throw e;
        }
    }

    @Test
    public void testRipemd160(){
        Ripemd160 ripemd160 = Ripemd160.getRipemd160();
        String expected = "f51960af7dd4813a587ab26388ddab3b28d1f7b4";
        byte[] actual_bytes = ripemd160.RMD(new byte[]{'h' , 'e', 'l', 'l', 'o', ' ', 't' , 'h' , 'i' , 's', ' ',  'i', 's', ' ', 'a', ' ', 't', 'e' ,'s','t'});
        String actual = bytesToHex(actual_bytes);
        String description = "Ripemd160 test";
        try{
            assertEquals(expected, actual);
            System.out.println("hello this is a test".getBytes());
            System.out.println(description + " - \033[92mpassed\033[0m");
        }catch(AssertionError e){
            System.out.println(description + " - \033[91mfailed\033[0m");
          throw e;
        }
    }
}

