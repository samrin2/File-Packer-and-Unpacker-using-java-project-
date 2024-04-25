import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;

public class MarvellousUnpack {
    FileOutputStream outstream = null;

    public MarvellousUnpack(String src) throws Exception {
        unpack(src);
    }

    public void unpack(String filePath) throws IOException, InvalidObjectException {
        try (FileInputStream instream = new FileInputStream(filePath)) {
            byte[] header = new byte[100];
            int length = 0;

            byte[] magic = new byte[12];
            instream.read(magic, 0, magic.length);

            String magicStr = new String(magic);

            if (!magicStr.equals("Marvellous11")) {
                throw new InvalidObjectException("Invalid packed file format");
            }

            while ((length = instream.read(header, 0, 100)) > 0) {
                String str = new String(header);

                String ext = str.substring(str.lastIndexOf("/") + 1);

                String[] words = ext.split("\\s");

                String filename = words[0];

                int size = Integer.parseInt(words[1]);

                byte[] arr = new byte[size];

                instream.read(arr, 0, size);

                try (FileOutputStream fout = new FileOutputStream(filename)) {
                    fout.write(arr, 0, size);
                }
            }
        } catch (IOException e) {
            throw new IOException("Error while unpacking: " + e.getMessage());
        }
    }
}
