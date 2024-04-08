import javax.swing.*;

import Comps.Area;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.prefs.Preferences;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.JFileChooser;
import java.io.FileWriter;

/**
 * GUI class
 */
public class Application extends JFrame {
    private static final String WIDTH_KEY = "width";
    private static final String HEIGHT_KEY = "height";
    private static final String POS_X = "x";
    private static final String POS_Y = "y";
    private Container cp;

    private File currentFile;
    private Area ar;

    private Preferences preferences;

    public Application() {
        super();
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        this.setTitle("Application");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        preferences = Preferences.userNodeForPackage(Application.class);
        int width = preferences.getInt(WIDTH_KEY, 300);
        int height = preferences.getInt(HEIGHT_KEY, 400);
        int posx = preferences.getInt(POS_X, 100);
        int posy = preferences.getInt(POS_Y, 100);

        this.setSize(width, height);
        this.setLocation(posx, posy);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                saveUserDimensions();
                System.exit(0);
            }
        });
        this.setupApp();
    }

    private void setupApp() {
        ar = new Area();
        cp.add(ar, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        // file menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenuItem newItem = new JMenuItem("New");
        // newItem accelerator to ctrl+n
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        fileMenu.add(newItem);
        fileMenu.addSeparator();
        JMenuItem openItem = new JMenuItem("Open");
        // saveItem accelerator to ctrl+o
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        fileMenu.add(openItem);
        JMenuItem saveItem = new JMenuItem("Save");
        // saveItem accelerator to ctrl+s
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        fileMenu.add(saveItem);
        JMenuItem saveAsItem = new JMenuItem("Save as");
        // saveAsItem accelerator to ctrl+shift+s
        saveAsItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK));
        fileMenu.add(saveAsItem);
        newItem.addActionListener(e -> newFile());
        openItem.addActionListener(e -> openFile());
        saveItem.addActionListener(e -> saveFile());
        saveAsItem.addActionListener(e -> saveFileAs());
    }

    private void newFile() {
        currentFile = null;
        ar.setText("");
    }

    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        // accept only .txt files
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return true;
            }

            @Override
            public String getDescription() {
                return "Text files";
            }
        });
        fileChooser.showOpenDialog(this);
        currentFile = fileChooser.getSelectedFile();
        // open file and read it
        if (currentFile != null) {
            // use BufferedReader to read the file line by line
            try {
                BufferedReader br = new BufferedReader(new FileReader(currentFile));
                String line;
                while ((line = br.readLine()) != null) {
                    ar.setText(ar.get() + line + "\n");
                }
                br.close();
            } catch (Exception e) {
            }
        }
    }

    private void saveFile() {
        if (currentFile == null) {
            saveFileAs();
        } else {
            try {
                FileWriter fw = new FileWriter(currentFile);
                fw.write(ar.get());
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveFileAs() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return true;
            }

            @Override
            public String getDescription() {
                return "Text files";
            }
        });
        fileChooser.showSaveDialog(this);
        currentFile = fileChooser.getSelectedFile();
        if (currentFile != null) {
            saveFile();
        }
    }

    public void saveUserDimensions() {
        preferences.putInt(WIDTH_KEY, getWidth());
        preferences.putInt(HEIGHT_KEY, getHeight());
        preferences.putInt(POS_X, getX());
        preferences.putInt(POS_Y, getY());
    }

    public void startApp(boolean packElements) {
        if (packElements)
            this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.startApp(false);
    }
}
