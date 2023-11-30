import java.util.Arrays;

public class Main {
    /**
     * @param n the number of jobs
     * @param t the times of jobs 1 through n, NB: you should ignore t[0]
     * @param d the deadlines of the jobs 1 through n. NB: you should ignore d[0]
     * @return the minimised maximum lateness L.
     */
    public static int solve(int n, int[] t, int[] d) {
        int time = 0;
        int minimumLateness = Integer.MIN_VALUE;
        Job[] jobs = new Job[n + 1];
        for (int i = 1; i <= n; i++) {
            jobs[i] = new Job(t[i], d[i]);
        }

        Arrays.sort(jobs, 1, n + 1);

        for (int i = 1; i <= n; i++) {
            time += jobs[i].time;

            //initally did Math.min here, but you want the maximum minimum lateness, as to say we won't be later that than
            // also made the of adding the lateness
            minimumLateness = Math.max(time - jobs[i].deadLine, minimumLateness);
        }



        return minimumLateness;
    }
}

class Job implements Comparable<Job>{
    int time;
    int deadLine;

    public Job(int time, int deadLine) {
        this.time = time;
        this.deadLine = deadLine;
    }

    @Override
    public int compareTo(Job j) {
        return Integer.compare(this.deadLine, j.deadLine);
    }
}