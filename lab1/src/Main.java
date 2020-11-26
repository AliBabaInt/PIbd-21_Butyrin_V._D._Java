public class Main {

    public static void main(String[] args) {
        FrameTank frameLocomotive = new FrameTank();
        DrawPanel drawPanel = new DrawPanel();
        frameLocomotive.addDrawPanel(drawPanel);
    }
}
