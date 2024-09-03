package com.github.Rah.jrl.flappybird.utils;

import com.github.Rah.jrl.flappybird.Pipe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GameOverInfo {
     private int y;
     private boolean groundCrash;
    private int basex;
    private Pipe[] upperPipes;
    private Pipe[] lowerPipes;
    private int score;
    private int playerVelY;
}
