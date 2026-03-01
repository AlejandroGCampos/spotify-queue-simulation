package queueHandler.handler;

import umg.edu.gt.data_structure.queue.manual.QueueLinked;

public class QueueManagerPlayer {

    private QueueLinked<Song> highPriority = new QueueLinked<>();
    private QueueLinked<Song> normalPriority = new QueueLinked<>();

    public void addSong(Song song) {
        if (song.getPriority() == 1) {
            highPriority.enqueue(song);
        } else {
            normalPriority.enqueue(song);
        }
    }

    public void startPlayback() {

        System.out.println("[LOG] Starting playlist...\n");

        while (!highPriority.isEmpty()) {
            play(highPriority.dequeue());
        }

        while (!normalPriority.isEmpty()) {
            play(normalPriority.dequeue());
        }

        System.out.println("[LOG] Playlist finished.");
    }

    private void play(Song song) {

        System.out.println("[LOG] Now playing: " + song);

        for (int i = 1; i <= song.getDuration(); i++) {
            try {
                Thread.sleep(1000); // 1 segundo real

                String bar = drawBar(i, song.getDuration());

                System.out.println(
                        "[LOG] Playing: " + song.getTitle() +
                        " | " + bar +
                        " " + i + "s / " + song.getDuration() + "s"
                );

            } catch (InterruptedException e) {
                System.out.println("Error en la reproducción.");
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("[LOG] Finished: " + song.getTitle() + "\n");
    }

    private String drawBar(int current, int total) {

        StringBuilder bar = new StringBuilder("[");
        int progress = (current * 10) / total;

        for (int i = 0; i < 10; i++) {
            if (i < progress) {
                bar.append("#");
            } else {
                bar.append("-");
            }
        }

        bar.append("]");
        return bar.toString();
    }
}