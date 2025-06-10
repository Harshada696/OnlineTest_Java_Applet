import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OnlineTest extends JFrame implements ActionListener {
    JButton htmlButton, javaButton, pythonButton, cssButton;
    JLabel htmlResultLabel, javaResultLabel, pythonResultLabel, cssResultLabel,  welcomeLabel;

    OnlineTest(String s) {
        super(s);
        // Create a JLabel to display the image
        JLabel imageLabel = new JLabel();
        imageLabel.setBounds(250, 50, 500, 500); 
        add(imageLabel);
        
        // Load the image using ImageIcon
        ImageIcon imageIcon = new ImageIcon("images.png"); 
        // Set the ImageIcon to the JLabel
        imageLabel.setIcon(imageIcon);
 welcomeLabel = new JLabel("Wel-come to Online Test !");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 15)); 
        welcomeLabel.setBounds(150, 50, 200, 80); 

        
        add(welcomeLabel);

        htmlButton = new JButton("HTML Test");
        javaButton = new JButton("Java Test");
        pythonButton = new JButton("Python Test");
        cssButton = new JButton("CSS Test");

        htmlButton.addActionListener(this);
        javaButton.addActionListener(this);
        pythonButton.addActionListener(this);
        cssButton.addActionListener(this);
        
htmlButton.setBackground(new Color(173, 216, 230)); 
javaButton.setBackground(new Color(152, 251, 152)); 
pythonButton.setBackground(new Color(255, 182, 193)); 
cssButton.setBackground(new Color(255, 218, 185)); 


        Font buttonFont = new Font("Arial", Font.BOLD, 15);
        htmlButton.setFont(buttonFont);
        javaButton.setFont(buttonFont);
        pythonButton.setFont(buttonFont);
        cssButton.setFont(buttonFont);

        // Set button sizes
        htmlButton.setPreferredSize(new Dimension(150, 80));
        javaButton.setPreferredSize(new Dimension(150, 80));
        pythonButton.setPreferredSize(new Dimension(150, 80));
        cssButton.setPreferredSize(new Dimension(150, 80));


        htmlButton.setBounds(50, 100, 150, 80);
        javaButton.setBounds(50, 190, 150, 80);
        pythonButton.setBounds(50, 280, 150, 80);
        cssButton.setBounds(50, 370, 150, 80);

        add(htmlButton);
        add(javaButton);
        add(pythonButton);
        add(cssButton);

        htmlResultLabel = new JLabel("");
        javaResultLabel = new JLabel("");
        pythonResultLabel = new JLabel("");
        cssResultLabel = new JLabel("");

        htmlResultLabel.setBounds(250, 100, 200, 30);
        javaResultLabel.setBounds(250, 150, 200, 30);
        pythonResultLabel.setBounds(250, 200, 200, 30);
        cssResultLabel.setBounds(250, 250, 200, 30);

        add(htmlResultLabel);
        add(javaResultLabel);
        add(pythonResultLabel);
        add(cssResultLabel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(800, 500);

        // Set background color
        getContentPane().setBackground(Color.PINK);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == htmlButton) {
            setVisible(false);
            HTMLTest htmlTest = new HTMLTest("HTML Test");
        } else if (e.getSource() == javaButton) {
            setVisible(false);
            int javaScore = startJavaTest();
            javaResultLabel.setText("Java Test Result: " + javaScore + "/5");
        } else if (e.getSource() == pythonButton) {
            setVisible(false);
            int pythonScore = startPythonTest();
            pythonResultLabel.setText("Python Test Result: " + pythonScore + "/5");
        } else if (e.getSource() == cssButton) {
            setVisible(false);
            int cssScore = startCSSTest();
            cssResultLabel.setText("CSS Test Result: " + cssScore + "/5");
        }
    }

    private int startJavaTest() {
        JavaTest javaTest = new JavaTest("Java Test");
     
        return (int) (Math.random() * 6);
    }

    private int startPythonTest() {
        PythonTest pythonTest = new PythonTest("Python Test");
       
        return (int) (Math.random() * 6);
    }

    private int startCSSTest() {
        CSSTest cssTest = new CSSTest("CSS Test");
       
        return (int) (Math.random() * 6);
    }

    public static void main(String[] args) {
        new OnlineTest("Select Test");
    }
}

class HTMLTest extends JFrame implements ActionListener {
    JLabel l;
    JRadioButton jb[] = new JRadioButton[4]; 
    JButton b1, b2;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];

    HTMLTest(String s) {
        super(s);
        l = new JLabel();
        add(l);
        bg = new ButtonGroup();
        for (int i = 0; i < 4; i++) { 
            jb[i] = new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1 = new JButton("Next");
        b2 = new JButton("Bookmark");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);
        add(b2);
        set();
        l.setBounds(30, 40, 450, 20);
       
        jb[0].setBounds(50, 80, 300, 20);
        jb[1].setBounds(50, 110, 300, 20);
        jb[2].setBounds(50, 140, 300, 20);
        jb[3].setBounds(50, 170, 300, 20);
        b1.setBounds(100, 240, 100, 30);
        b2.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);

    
        getContentPane().setBackground(Color.PINK);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (check())
                count = count + 1;
            current++;
            set();
            if (current == 5) {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 5)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        
        for (int i = 0, y = 1; i < x - 1; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (check())
                    count = count + 1;
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }
        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            JOptionPane.showMessageDialog(this, "correct ans=" + count);
            System.exit(0);
        }
    }

    void set() {
        
        bg.clearSelection();

     
        l.setFont(new Font("Arial", Font.PLAIN, 14));
        for (int i = 0; i < 4; i++) {
            jb[i].setFont(new Font("Arial", Font.PLAIN, 12)); 
        }

        
        jb[0].setSelected(true);
        if (current == 0) {
            l.setText("Que1: Which of the following tag is used to create an unordered list?");
            jb[0].setText("<ul>");
            jb[1].setText("<ol>");
            jb[2].setText("<li>");
            jb[3].setText("<i>");
        }
        if (current == 1) {
            l.setText("Que2: What is the HTML tag under which one can write the JavaScript code?");
            jb[0].setText("<javascript>");
            jb[1].setText("<scripted>");
            jb[2].setText("<script>");
            jb[3].setText("<js>");
        }
        if (current == 2) {
            l.setText("Que3: Which of the following attribute triggers the execution of JavaScript code when user clicks on it?");
            jb[0].setText("href");
            jb[1].setText("onmouseover");
            jb[2].setText("onclick");
            jb[3].setText("onchange");
        }
        if (current == 3) {
            l.setText("Que4: In JavaScript, what is a block of statement?");
            jb[0].setText("Conditional block");
            jb[1].setText("block that combines a number of statements into a single compound statement");
            jb[2].setText("both conditional block and a single statement");
            jb[3].setText("block that contains a single statement");
        }
        if (current == 4) {
            l.setText("Que5: What is the syntax for creating a function in JavaScript named as Square?");
            jb[0].setText("function = myfunction()");
            jb[1].setText("function Square()");
            jb[2].setText("function = Square()");
            jb[3].setText("function : Square()");
        }
        l.setBounds(30, 40, 450, 20);
        // Adjusted bounds for radio buttons
        jb[0].setBounds(50, 80, 300, 20);
        jb[1].setBounds(50, 110, 300, 20);
        jb[2].setBounds(50, 140, 300, 20);
        jb[3].setBounds(50, 170, 300, 20);
    }

    boolean check() {
        if (current == 0)
            return (jb[1].isSelected());
        if (current == 1)
            return (jb[2].isSelected());
        if (current == 2)
            return (jb[2].isSelected());
        if (current == 3)
            return (jb[1].isSelected());
        if (current == 4)
            return (jb[1].isSelected());
        return false;
    }

    public static void main(String s[]) {
        new HTMLTest("HTML Test");
    }
}

class JavaTest extends JFrame implements ActionListener {
    JLabel l;
    JRadioButton jb[] = new JRadioButton[4]; 
    JButton b1, b2;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];

    JavaTest(String s) {
        super(s);
        l = new JLabel();
        add(l);
        bg = new ButtonGroup();
        for (int i = 0; i < 4; i++) { 
            jb[i] = new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1 = new JButton("Next");
        b2 = new JButton("Bookmark");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);
        add(b2);
        set();
        l.setBounds(30, 40, 450, 20);
        
        jb[0].setBounds(50, 80, 300, 20);
        jb[1].setBounds(50, 110, 300, 20);
        jb[2].setBounds(50, 140, 300, 20);
        jb[3].setBounds(50, 170, 300, 20);
        b1.setBounds(100, 240, 100, 30);
        b2.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
        getContentPane().setBackground(Color.PINK);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (check())
                count = count + 1;
            current++;
            set();
            if (current == 5) {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 5)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
     
        for (int i = 0, y = 1; i < x - 1; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (check())
                    count = count + 1;
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }
        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            JOptionPane.showMessageDialog(this, "correct ans=" + count);
            System.exit(0);
        }
    }

    void set() {
   
        bg.clearSelection();

       
        l.setFont(new Font("Arial", Font.PLAIN, 14));
        for (int i = 0; i < 4; i++) {
            jb[i].setFont(new Font("Arial", Font.PLAIN, 12)); // Set font for radio buttons
        }

    
        switch (current) {
            case 0:
                l.setText("Que1: What is the output of the following Java code?\n\npublic class Main {\n    public static void main(String[] args) {\n        int x = 5;\n        System.out.println(x++);\n    }\n}");
                jb[0].setText("5");
                jb[1].setText("6");
                jb[2].setText("7");
                jb[3].setText("Compiler Error");
                break;
            case 1:
                l.setText("Que2: Which of the following is not a valid Java identifier?");
                jb[0].setText("total_marks");
                jb[1].setText("first_name");
                jb[2].setText("2nd_name");
                jb[3].setText("$salary");
                break;
            case 2:
                l.setText("Que3: What is the size of char datatype in Java?");
                jb[0].setText("4 bits");
                jb[1].setText("8 bits");
                jb[2].setText("16 bits");
                jb[3].setText("32 bits");
                break;
            case 3:
                l.setText("Que4: What is the size of byte datatype in Java?");
                jb[0].setText("4 bits");
                jb[1].setText("8 bits");
                jb[2].setText("16 bits");
                jb[3].setText("32 bits");
                break;
            case 4:
                l.setText("Que5: Which keyword is used to exit a loop in Java?");
                jb[0].setText("exit");
                jb[1].setText("quit");
                jb[2].setText("break");
                jb[3].setText("continue");
                break;
        }
    }

    boolean check() {
        
        switch (current) {
            case 0:
                return jb[1].isSelected();
            case 1:
                return jb[2].isSelected();
            case 2:
                return jb[2].isSelected();
            case 3:
                return jb[1].isSelected();
            case 4:
                return jb[2].isSelected();
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        new JavaTest("Java Test");
    }
}


class PythonTest extends JFrame implements ActionListener {
    JLabel l;
    JRadioButton jb[] = new JRadioButton[4];
    JButton b1, b2;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];

    PythonTest(String s) {
        super(s);
        l = new JLabel();
        add(l);
        bg = new ButtonGroup();
        for (int i = 0; i < 4; i++) { 
            jb[i] = new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1 = new JButton("Next");
        b2 = new JButton("Bookmark");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);
        add(b2);
        set();
        l.setBounds(30, 40, 450, 60); 
        jb[0].setBounds(50, 110, 300, 20);
        jb[1].setBounds(50, 140, 300, 20);
        jb[2].setBounds(50, 170, 300, 20);
        jb[3].setBounds(50, 200, 300, 20);
        b1.setBounds(100, 240, 100, 30);
        b2.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
getContentPane().setBackground(Color.PINK);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (check())
                count = count + 1;
            current++;
            set();
            if (current == 5) {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 5)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
      
        for (int i = 0, y = 1; i < x - 1; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (check())
                    count = count + 1;
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }
        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            JOptionPane.showMessageDialog(this, "correct ans=" + count);
            System.exit(0);
        }
    }

    void set() {
      
        bg.clearSelection();

       
        l.setFont(new Font("Arial", Font.PLAIN, 14));
        for (int i = 0; i < 4; i++) {
            jb[i].setFont(new Font("Arial", Font.PLAIN, 12)); 
        }

       
        switch (current) {
            case 0:
                l.setText("Que1: What will be the output of the following Python code?\n\nx = 10\nprint(x > 5 and x < 15)");
                jb[0].setText("True");
                jb[1].setText("False");
                jb[2].setText("Error");
                jb[3].setText("None");
                break;
            case 1:
                l.setText("Que2: Which of the following is a correct syntax for a comment in Python?");
                jb[0].setText("// This is a comment");
                jb[1].setText("# This is a comment");
                jb[2].setText("/* This is a comment */");
                jb[3].setText("<!-- This is a comment -->");
                break;
            case 2:
                l.setText("Que3: How do you start writing an if statement in Python?");
                jb[0].setText("if(condition)");
                jb[1].setText("if condition:");
                jb[2].setText("if condition then:");
                jb[3].setText("if condition begin");
                break;
            case 3:
                l.setText("Que4: What is the output of the following Python code?\n\nx = 5\nprint(x % 2 == 0)");
                jb[0].setText("True");
                jb[1].setText("False");
                jb[2].setText("Error");
                jb[3].setText("None");
                break;
            case 4:
                l.setText("Que5: What does the 'print' function do in Python?");
                jb[0].setText("It reads input from the user.");
                jb[1].setText("It displays text on the screen.");
                jb[2].setText("It performs arithmetic operations.");
                jb[3].setText("It imports modules from Python libraries.");
                break;
        }
    }

    boolean check() {
       
        switch (current) {
            case 0:
                return jb[0].isSelected();
            case 1:
                return jb[1].isSelected();
            case 2:
                return jb[1].isSelected();
            case 3:
                return jb[1].isSelected();
            case 4:
                return jb[1].isSelected();
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        new PythonTest("Python Test");
    }
}

class CSSTest extends JFrame implements ActionListener {
    JLabel l;
    JRadioButton jb[] = new JRadioButton[4]; 
    JButton b1, b2;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];

    CSSTest(String s) {
        super(s);
        l = new JLabel();
        add(l);
        bg = new ButtonGroup();
        for (int i = 0; i < 4; i++) { 
            jb[i] = new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1 = new JButton("Next");
        b2 = new JButton("Bookmark");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);
        add(b2);
        set();
        l.setBounds(30, 40, 450, 20);
      
        jb[0].setBounds(50, 80, 300, 20);
        jb[1].setBounds(50, 110, 300, 20);
        jb[2].setBounds(50, 140, 300, 20);
        jb[3].setBounds(50, 170, 300, 20);
        b1.setBounds(100, 240, 100, 30);
        b2.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
getContentPane().setBackground(Color.PINK);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (check())
                count = count + 1;
            current++;
            set();
            if (current == 5) {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 5)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
    
        for (int i = 0, y = 1; i < x - 1; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (check())
                    count = count + 1;
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }
        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            JOptionPane.showMessageDialog(this, "correct ans=" + count);
            System.exit(0);
        }
    }

    void set() {
     
        bg.clearSelection();

      
        l.setFont(new Font("Arial", Font.PLAIN, 14));
        for (int i = 0; i < 4; i++) {
            jb[i].setFont(new Font("Arial", Font.PLAIN, 12)); // Set font for radio buttons
        }

  
        switch (current) {
            case 0:
                l.setText("Que1: What does CSS stand for?");
                jb[0].setText("Computer Style Sheets");
                jb[1].setText("Cascading Style Sheets");
                jb[2].setText("Creative Style Sheets");
                jb[3].setText("Colorful Style Sheets");
                break;
            case 1:
                l.setText("Que2: Which property is used to change the background color?");
                jb[0].setText("color");
                jb[1].setText("bgcolor");
                jb[2].setText("background-color");
                jb[3].setText("bgcolor-color");
                break;
            case 2:
                l.setText("Que3: Which CSS property is used to control the text size?");
                jb[0].setText("text-style");
                jb[1].setText("font-style");
                jb[2].setText("text-size");
                jb[3].setText("font-size");
                break;
            case 3:
                l.setText("Que4: How do you select elements with class name 'example' in CSS?");
                jb[0].setText("#example");
                jb[1].setText(".example");
                jb[2].setText("example");
                jb[3].setText("*example");
                break;
            case 4:
                l.setText("Que5: Which CSS property is used to set the margin between the border and the content?");
                jb[0].setText("padding");
                jb[1].setText("margin");
                jb[2].setText("spacing");
                jb[3].setText("border-spacing");
                break;
        }
    }

    boolean check() {
   
        switch (current) {
            case 0:
                return jb[1].isSelected();
            case 1:
                return jb[2].isSelected();
            case 2:
                return jb[3].isSelected();
            case 3:
                return jb[1].isSelected();
            case 4:
                return jb[1].isSelected();
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        new CSSTest("CSS Test");
    }
}
