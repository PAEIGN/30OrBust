public class Player {
    private String name;
    private int totalNum = 0;
    private int winningScore = 30;

    public void displayScore(){
        System.out.println(name + " has a total score of " + totalNum + ".");
    }

    public void updateScore(int roll){
        totalNum += roll;
    }

    public boolean checkScore(){
        if (totalNum > winningScore){
            System.out.println("");
            System.out.println(name + " reached a score of " + totalNum + " and reset back to 0.");
            totalNum = 0;
            return false;
        }
        else if (totalNum == winningScore){
            System.out.println("");
            System.out.println(name + " reached a score of " + totalNum + " and is the winner!");
            return true;
        }
        else{
            System.out.println("");
            System.out.println(name + " has a score of " + totalNum + " and needs " + (winningScore - totalNum) + " more point(s) to win.");
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public void setWinningScore(int winningScore) { this.winningScore = winningScore; }
}