package Game.GameStates.Zelda;

import Game.GameStates.State;
import Main.Handler;
import Resources.Animation;
import Resources.Images;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by AlexVR on 3/14/2020
 */
public class ZeldaIntroStates extends State {
    private Animation introAnimation;
    private int stage = 0;
    private int stageCounter = 60 * 3; // 3 seconds
    private int yStoryOffset = 0;
    public ZeldaIntroStates(Handler handler) {
        super(handler);
        introAnimation = new Animation(100, Images.zeldaTitleFrames);
    }
     public boolean ZeldaPlayed=false;

    @Override
    public void tick() {        	
    	if(!ZeldaPlayed) {
        	handler.getMusicHandler().startMusic("Zelda.wav");
        	ZeldaPlayed=true;}
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER)){
        	handler.getMusicHandler().stopMusic();
        	handler.changeState(handler.getZeldaGameState());
        }
        if(stage == 0) {
            introAnimation.tick();
        }else if(stage==1){
            if (stageCounter< 60*42){
                yStoryOffset +=3;

            }
        }else{
            handler.changeState(handler.getZeldaGameState());
        }
        if(stageCounter==0){
            stageCounter = 60 * 45;
            stage++;
        }else{
            stageCounter--;
        }

    }

    @Override
    public void render(Graphics g) {
        if(stage == 0){
            g.drawImage(introAnimation.getCurrentFrame(),handler.getWidth()/4,0 ,handler.getWidth()/2,handler.getHeight(),null);
        }else if(stage ==1){
            for(int i=0; i<Images.zeldaStoryFrames.length;i++){
                g.drawImage(Images.zeldaStoryFrames[i],handler.getWidth()/4,handler.getHeight()*i -yStoryOffset ,handler.getWidth()/2,handler.getHeight(),null);
            }
        }
    }

    @Override
    public void refresh() {

    }
}
