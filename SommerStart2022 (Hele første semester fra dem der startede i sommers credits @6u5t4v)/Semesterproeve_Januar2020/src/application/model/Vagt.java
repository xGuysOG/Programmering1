package application.model;

public class Vagt {
    private int timer;

    // Link Attributer
    private Job job;
    private Frivillig frivillig;

    public Vagt(int timer, Frivillig frivillig, Job job) {
        this.timer = timer;
        this.frivillig = frivillig;
        frivillig.addVagt(this);
        this.job = job;
    }

    public void setFrivillig(Frivillig frivillig) {
        if (this.frivillig != frivillig) {
            Frivillig old = this.frivillig;
            if (old != null) {
                old.removeVagt(this);
            }

            this.frivillig = frivillig;
            if (frivillig != null) {
                frivillig.addVagt(this);
            }
        }
    }

    public Job getJob() {
        return job;
    }

    public Frivillig getFrivillig() {
        return frivillig;
    }

    public int getTimer() {
        return timer;
    }
}
