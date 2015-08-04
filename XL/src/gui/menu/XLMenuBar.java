package gui.menu;

import gui.Current;
import gui.StatusLabel;
import gui.XL;
import gui.XLList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import model.SlotList;

public class XLMenuBar extends JMenuBar {
    public XLMenuBar(XL xl, XLList xlList, StatusLabel statusLabel, Current current, SlotList slotList) {
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        file.add(new PrintMenuItem(xl, statusLabel));
        file.add(new SaveMenuItem(xl, statusLabel));
        file.add(new LoadMenuItem(xl, statusLabel));
        file.add(new NewMenuItem(xl));
        file.add(new CloseMenuItem(xl, xlList));
        edit.add(new ClearMenuItem(current , statusLabel, slotList));
        edit.add(new ClearAllMenuItem(xl));
        add(file);
        add(edit);
        add(new WindowMenu(xlList));
    }
}