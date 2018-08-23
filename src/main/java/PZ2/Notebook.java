package PZ2;

/**
 * Created by gaara on 09.08.16.
 */
public class Notebook {
    String id;
    String price;
    String title;
    String diag;
    String screensize;
    String surface;
    String proc;
    String ram;
    String hdd;
    String video;
    String lan;
    String wifi;
    String bt;
    String usb2;
    String cardreader;
    String webcam;
    String battery;
    String batterycapacity;
    String OS;
    String color;
    String size;
    String weightl;
    String garanty;

    public Notebook(String id, String price, String title, String diag, String screensize, String surface, String proc, String ram, String hdd, String video, String lan, String wifi, String bt, String usb2, String cardreader, String webcam, String battery, String batterycapacity, String OS, String color, String size, String weightl, String garanty) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.diag = diag;
        this.screensize = screensize;
        this.surface = surface;
        this.proc = proc;
        this.ram = ram;
        this.hdd = hdd;
        this.video = video;
        this.lan = lan;
        this.wifi = wifi;
        this.bt = bt;
        this.usb2 = usb2;
        this.cardreader = cardreader;
        this.webcam = webcam;
        this.battery = battery;
        this.batterycapacity = batterycapacity;
        this.OS = OS;
        this.color = color;
        this.size = size;
        this.weightl = weightl;
        this.garanty = garanty;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id='" + id + '\'' +
                ", price='" + price + '\'' +
                ", title='" + title + '\'' +
                ", diag='" + diag + '\'' +
                ", screensize='" + screensize + '\'' +
                ", surface='" + surface + '\'' +
                ", proc='" + proc + '\'' +
                ", ram='" + ram + '\'' +
                ", hdd='" + hdd + '\'' +
                ", video='" + video + '\'' +
                ", lan='" + lan + '\'' +
                ", wifi='" + wifi + '\'' +
                ", bt='" + bt + '\'' +
                ", usb2='" + usb2 + '\'' +
                ", cardreader='" + cardreader + '\'' +
                ", webcam='" + webcam + '\'' +
                ", battery='" + battery + '\'' +
                ", batterycapacity='" + batterycapacity + '\'' +
                ", OS='" + OS + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", weightl='" + weightl + '\'' +
                ", garanty='" + garanty + '\'' +
                '}';
    }
}
