package queueHandler.handler;

public class App {

    public static void main(String[] args) {

        QueueManagerPlayer manager = new QueueManagerPlayer();

        // Agrego mi música
        manager.addSong(new Song("Do I Wanna Know?", "Arctic Monkeys", 8, 1));
        manager.addSong(new Song("Sweater Weather", "The Neighbourhood", 6, 2));
        manager.addSong(new Song("Feel Good Inc.", "Gorillaz", 10, 1));
        manager.addSong(new Song("505", "Arctic Monkeys", 7, 2));

        // Inicia la simulación
        manager.startPlayback();
    }
}
