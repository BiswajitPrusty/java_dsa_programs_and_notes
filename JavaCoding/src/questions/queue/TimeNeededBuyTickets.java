package questions.queue;

public class TimeNeededBuyTickets {

    public static void main(String[] args) {
        System.out.println(timeRequiredToBuy(new int[]{5,1,1,1}, 0));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        while(tickets[k] != 0){
            for(int i = 0 ; i < tickets.length ; i++){
                if(tickets[i] != 0 && tickets[k] != 0){
                    tickets[i]--;
                    time++;
                }
            }
        }

        return time;
    }
}
