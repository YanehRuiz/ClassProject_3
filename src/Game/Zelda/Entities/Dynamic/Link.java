package Game.Zelda.Entities.Dynamic;

import Game.GameStates.Zelda.ZeldaGameState;
import Game.Zelda.Entities.Statics.DungeonDoor;
import Game.Zelda.Entities.Statics.SectionDoor;
import Game.Zelda.Entities.Statics.SolidStaticEntities;
import Main.Handler;
import Resources.Animation;
import Resources.Images;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import static Game.GameStates.Zelda.ZeldaGameState.worldScale;
import static Game.Zelda.Entities.Dynamic.Direction.DOWN;
import static Game.Zelda.Entities.Dynamic.Direction.UP;

/**
 * Created by AlexVR on 3/15/2020
 */
public class Link extends BaseMovingEntity {


	private final int animSpeed = 120;
	int newMapX=0,newMapY=0,xExtraCounter=0,yExtraCounter=0;
	public boolean movingMap = false;
	Direction movingTo;


	public Link(int x, int y, BufferedImage[] sprite, Handler handler) {
		super(x, y, sprite, handler);
		speed = 4;
		health = 6;
		BufferedImage[] animList = new BufferedImage[2];
		animList[0] = sprite[4];
		animList[1] = sprite[5];

		animation = new Animation(animSpeed,animList);
	
	}

	@Override
	public void tick() {
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_H) && health < 6){ 
	    	health++;}
		
		
		if (movingMap){
			switch (movingTo) {
//			case RIGHT:
//				handler.getZeldaGameState().cameraOffsetX++;
//			//	handler.getZeldaGameState().cameraOffsetX+=2;
//				//newMapX+=2;	
//				newMapX++;
//				
//				if (xExtraCounter>0){
//					x+=6;
//					xExtraCounter--;
//					animation.tick();
////				if(newMapX>=0) {
////						newMapX=0; }
//
//
//				}else{
//					x--;
//				}
//				break;
//				
//			case LEFT:
//				handler.getZeldaGameState().cameraOffsetX--;
//				newMapX--;
//				//newMapX-=2;		
////				if(newMapX<=0) {
////						newMapX=0;}
//				if (xExtraCounter>0){
//					x-=6;
//					xExtraCounter--;
//					animation.tick();
//			
//
//
//				}else{
//					x++;
//				}
//				break;
//			case UP:
//				handler.getZeldaGameState().cameraOffsetY--;
//				newMapY++;
////				if(newMapY>=0) {
////						newMapY=0;}
//				if (yExtraCounter>0){
//					y-=6;
//					yExtraCounter--;
//					animation.tick();
//					
//
//
//				}else{
//					y++;
//				}
//				break;
//			case DOWN:
//				handler.getZeldaGameState().cameraOffsetY++;
//				newMapY--;
////				if(newMapY<=0) {
////				newMapY=0;}
//				if (yExtraCounter>0){
//					y+=2;
//					yExtraCounter--;
//					animation.tick();		
//					
//					
//		
//
//				}else{
//					y--;
//				}
//				break;
//			}
//			bounds = new Rectangle(x,y,width,height);
//			changeIntersectingBounds();
//
//			
//			if (newMapX == 0 && newMapY == 0){ 
//				movingMap = false;
//				movingTo = null;
//				newMapX = 0;
//				newMapY = 0;
//			}
//		}else {
//			if (handler.getKeyManager().up) {
//				if (direction != UP) {
//					BufferedImage[] animList = new BufferedImage[2];
//					animList[0] = sprites[4];
//					animList[1] = sprites[5];
//					animation = new Animation(animSpeed, animList);
//					direction = UP;
//					sprite = sprites[4];
//				}
//				animation.tick();
//				move(direction);
			
			case RIGHT:
                handler.getZeldaGameState().cameraOffsetX++;
                newMapX++;
                if (xExtraCounter>0){
                    x+=2;
                    xExtraCounter--;
                    animation.tick();

                }else{
                    x--;
                }
                break;
            case LEFT:
                handler.getZeldaGameState().cameraOffsetX--;
                newMapX--;
                if (xExtraCounter>0){
                    x-=2;
                    xExtraCounter--;
                    animation.tick();

                }else{
                    x++;
                }
                break;
            case UP:
                handler.getZeldaGameState().cameraOffsetY--;
                newMapY++;
                if (yExtraCounter>0){
                    y-=2;
                    yExtraCounter--;
                    animation.tick();

                }else{
                    y++;
                }
                break;
            case DOWN:
                handler.getZeldaGameState().cameraOffsetY++;
                newMapY--;
                if (yExtraCounter>0){
                    y+=2;
                    yExtraCounter--;
                    animation.tick();
                }else{
                    y--;
                }
                break;
        }
        bounds = new Rectangle(x,y,width,height);
        changeIntersectingBounds();
        if (newMapX == 0 && newMapY == 0){
            movingMap = false;
            movingTo = null;
            newMapX = 0;
            newMapY = 0;
        }
    }else {
        if (handler.getKeyManager().up) {
            if (direction != UP) {
                BufferedImage[] animList = new BufferedImage[2];
                animList[0] = sprites[4];
                animList[1] = sprites[5];
                animation = new Animation(animSpeed, animList);
                direction = UP;
                sprite = sprites[4];
            }
            animation.tick();
            move(direction);

			} else if (handler.getKeyManager().down) {
				if (direction != DOWN) {
					BufferedImage[] animList = new BufferedImage[2];
					animList[0] = sprites[0];
					animList[1] = sprites[1];
					animation = new Animation(animSpeed, animList);
					direction = DOWN;
					sprite = sprites[0];
				}
				animation.tick();
				move(direction);
			} else if (handler.getKeyManager().left) {
				if (direction != Direction.LEFT) {
					BufferedImage[] animList = new BufferedImage[2];
					animList[0] = Images.flipHorizontal(sprites[2]);
					animList[1] = Images.flipHorizontal(sprites[3]);
					animation = new Animation(animSpeed, animList);
					direction = Direction.LEFT;
					sprite = Images.flipHorizontal(sprites[3]);
				}
				animation.tick();
				move(direction);
			} else if (handler.getKeyManager().right) {
				if (direction != Direction.RIGHT) {
					BufferedImage[] animList = new BufferedImage[2];
					animList[0] = (sprites[2]);
					animList[1] = (sprites[3]);
					animation = new Animation(animSpeed, animList);
					direction = Direction.RIGHT;
					sprite = (sprites[3]);
				}
				animation.tick();
				move(direction);
			} else {
				moving = false;
			}
		}
	}

	@Override
	public void render(Graphics g) {
		if (moving) {
			g.drawImage(animation.getCurrentFrame(),x , y, width , height  , null);

		} else {
			if (movingMap){
				g.drawImage(animation.getCurrentFrame(),x , y, width, height  , null);
			}
			g.drawImage(sprite, x , y, width , height , null);
		}
	}

	@Override
	public void move(Direction direction) {
		moving = true;
		changeIntersectingBounds();
		//chack for collisions
		if (ZeldaGameState.inCave){
			for (SolidStaticEntities objects : handler.getZeldaGameState().caveObjects) {
				if ((objects instanceof DungeonDoor) && objects.bounds.intersects(bounds) && direction == ((DungeonDoor) objects).direction) {
					if (((DungeonDoor) objects).name.equals("caveStartLeave")) {
						ZeldaGameState.inCave = false;
						x = ((DungeonDoor) objects).nLX;
						y = ((DungeonDoor) objects).nLY;
						direction = DOWN;
					}
				} else if (!(objects instanceof DungeonDoor) && objects.bounds.intersects(interactBounds)) {
					//dont move
					return;
				}
			}
		}
		else {
			for (SolidStaticEntities objects : handler.getZeldaGameState().objects.get(handler.getZeldaGameState().mapX).get(handler.getZeldaGameState().mapY)) {
				if ((objects instanceof SectionDoor) && objects.bounds.intersects(bounds) && direction == ((SectionDoor) objects).direction) {
					if (!(objects instanceof DungeonDoor)) {
						movingMap = true;
						movingTo = ((SectionDoor) objects).direction;
						switch (((SectionDoor) objects).direction) {
						case RIGHT:
							newMapX = -(((handler.getZeldaGameState().mapWidth) + 1) * worldScale);
							newMapY = 0;
							handler.getZeldaGameState().mapX++;
							xExtraCounter = 8 * worldScale + (2 * worldScale);
							break;
						case LEFT:
							newMapX = (((handler.getZeldaGameState().mapWidth) + 1) * worldScale);
							newMapY = 0;
							handler.getZeldaGameState().mapX--;
							xExtraCounter = 8 * worldScale + (2 * worldScale);
							break;
						case UP:
							newMapX = 0;
							newMapY = -(((handler.getZeldaGameState().mapHeight) + 1) * worldScale);
							handler.getZeldaGameState().mapY--;
							yExtraCounter = 8 * worldScale + (2 * worldScale);
							break;
						case DOWN:
							newMapX = 0;
							newMapY = (((handler.getZeldaGameState().mapHeight) + 1) * worldScale);
							handler.getZeldaGameState().mapY++;
							yExtraCounter = 8 * worldScale + (2 * worldScale);
							break;
						}
						return;
					}
					else {
						if (((DungeonDoor) objects).name.equals("caveStartEnter")) {
							ZeldaGameState.inCave = true;
							x = ((DungeonDoor) objects).nLX;
							y = ((DungeonDoor) objects).nLY;
							direction = UP;
						}
					}
				}
				else if (!(objects instanceof SectionDoor) && objects.bounds.intersects(interactBounds)) {
					//dont move
					return;
				}
			}
		}
		switch (direction) {
		case RIGHT:
			x += speed;
			break;
		case LEFT:
			x -= speed;

			break;
		case UP:
			y -= speed;
			break;
		case DOWN:
			y += speed;

			break;
		}
		bounds.x = x;
		bounds.y = y;
		changeIntersectingBounds();

	}
}
