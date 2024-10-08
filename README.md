
# Usage

Git clone the project, run make.ps1 or make.sh to build the reinforcement-learning-flappy-bird.jar in the bin folder. 

Next run the following java command:

```bash
java -jar bin/reinforcement-learning-flappy-bird.jar
```

With the flappy bird game opened, press the "Start" button to start, "Accelerate" button to accelerate the game and learning,
"Stop" button to stop the game.



# Q Learning with Flappy Bird

The following java codes show the implementation of the Q-learn bot  


```java
public class QBot extends Bot {

    private final QLearner agent;

    public QBot(Game game, QLearner agent) {
        super(game);
        this.agent = agent;

    }

    @Override
    protected int selectAction(int state) {
        double q0 = this.agent.getModel().getQ(state, 0);
        double q1 = this.agent.getModel().getQ(state, 1);
        if(q0 >= q1) return 0;
        return 1;
    }

    @Override
    public void updateStrategy() {


        //agent.update(lastState, lastAction, game.stateText(0, 0, 10), -1000);

         // Flag if the bird died in the top pipe
        int y_dif = Integer.parseInt(game.stateText(moves.get(moves.size()-1).newState).split("_")[1]);
        boolean high_death_flag = y_dif > 120;

        for(int i=moves.size()-1; i >=0; --i){
            Move move = moves.get(i);
            double r = move.reward;
            if(i == moves.size()-1 || i == moves.size() - 2) {
                r = -1000;
            } else if(high_death_flag && move.action == 1) {
                r = -1000;
                high_death_flag = false;
            }

            agent.update(move.oldState, move.action, move.newState, r);
        }

        reset();

    }
}
```


