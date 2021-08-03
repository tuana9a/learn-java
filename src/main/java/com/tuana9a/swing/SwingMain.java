package com.tuana9a.swing;

import javax.swing.*;

public class SwingMain {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Client");
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setLayout(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        JScrollPane jScrollPane = new JScrollPane();

        JTextArea textArea0 = new JTextArea("tuan nguyen minh0");
        JTextArea textArea1 = new JTextArea("tuan nguyen minh1");
        JTextArea textArea2 = new JTextArea("tuan nguyen minh2");
        JTextArea textArea3 = new JTextArea("tuan nguyen minh3");
        JTextArea textArea4 = new JTextArea("tuan nguyen minh4");
        JPanel jPanel = new JPanel();
        jPanel.add(textArea0);
        jPanel.add(textArea1);
        jPanel.add(textArea2);
        jPanel.add(textArea3);
        jPanel.add(textArea4);

        JScrollPane scroll = new JScrollPane(jPanel);

//        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jFrame.add(jPanel);
        jFrame.add(textArea0);
        jFrame.add(textArea1);
        jFrame.add(textArea2);
        jFrame.add(textArea3);
        jFrame.add(scroll);


        jFrame.setSize(500,500);
        jFrame.setVisible(true);
    }
}
