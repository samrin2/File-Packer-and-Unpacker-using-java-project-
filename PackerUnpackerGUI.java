import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class PackerUnpackerGUI extends Frame implements ActionListener {
    private Label directoryLabel, packedFileLabel;
    private TextField directoryField, packedFileField;
    private Button packButton;

    public PackerUnpackerGUI() {
        setTitle("Marvellous Packer Unpacker");
        setSize(400, 200);
        setLayout(null);

        directoryLabel = new Label("Directory:");
        directoryLabel.setBounds(50, 50, 70, 20);
        add(directoryLabel);

        directoryField = new TextField();
        directoryField.setBounds(130, 50, 200, 20);
        add(directoryField);

        packedFileLabel = new Label("Packed File:");
        packedFileLabel.setBounds(50, 80, 70, 20);
        add(packedFileLabel);

        packedFileField = new TextField();
        packedFileField.setBounds(130, 80, 200, 20);
        add(packedFileField);

        packButton = new Button("Pack");
        packButton.setBounds(170, 120, 60, 30);
        packButton.addActionListener(this);
        add(packButton);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == packButton) {
            String directoryName = directoryField.getText();
            String packedFile = packedFileField.getText();

            try {
                packFiles(directoryName, packedFile);
            } catch (Exception e) {
                System.out.println("Exception occurred: " + e);
            }
        }
    }

    private void packFiles(String directoryName, String packedFile) throws Exception {
        boolean bret = false;
        File fobjPack = new File(packedFile);
        bret = fobjPack.createNewFile();
        if (bret == false) {
            System.out.println("Unable to create packed file...");
            return;
        }

        System.out.println("Packed file gets successfully created in the current directory.");

        File fobj = new File(directoryName);
        bret = fobj.isDirectory();

        if (bret) {
            File[] arr = fobj.listFiles();
            System.out.println("Number of files in the directory are : " + arr.length);

            String header = null;

            FileOutputStream fcombine = new FileOutputStream(packedFile);
            int iRet = 0;
            byte[] buffer = new byte[1024];

            System.out.println("Packing activity started...");

            for (int i = 0; i < arr.length; i++) {
                header = arr[i].getName() + " " + arr[i].length();
                System.out.println("File packed with the name : " + arr[i].getName());

                for (int j = header.length(); j < 100; j++) {
                    header = header + " ";
                }

                byte[] hArr = header.getBytes();
                fcombine.write(hArr, 0, 100);

                FileInputStream fiobj = new FileInputStream(arr[i]);

                while ((iRet = fiobj.read(buffer)) != -1) {
                    fcombine.write(buffer, 0, iRet);
                }
                fiobj.close();
            }

            System.out.println("Packing activity completed..");
            System.out.println("Total files packed successfully : " + arr.length);
        } else {
            System.out.println("There is no such directory");
        }
    }

    public static void main(String[] args) {
        PackerUnpackerGUI gui = new PackerUnpackerGUI();
        gui.setVisible(true);
    }
}
