package age.of.civilizations2.jakowski.lukasz;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;

class Button_Statistics_Happiness extends Button_Statistics {
   protected int iImageID;

   protected Button_Statistics_Happiness(float nHappiness, int iTextPosX, int iPosX, int iPosY, int iWidth, int iHeight) {
      super("" + (int)nHappiness + "%", iTextPosX, iPosX, iPosY, iWidth, iHeight);
      this.iImageID = CFG.getHappinesImage((int)nHappiness);
   }

   @Override
   protected void drawText(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
      Rectangle clipBounds = new Rectangle(
         (float)(this.getPosX() + iTranslateX), (float)(CFG.GAME_HEIGHT - this.getPosY() - iTranslateY), (float)this.getWidth(), (float)(-this.getHeight())
      );
      oSB.flush();
      ScissorStack.pushScissors(clipBounds);
      ImageManager.getImage(this.iImageID)
         .draw(
            oSB,
            this.getPosX() + this.getTextPos() + iTranslateX,
            this.getPosY()
               + this.getHeight() / 2
               - (int)((float)ImageManager.getImage(this.iImageID).getHeight() * this.getImageScale()) / 2
               - ImageManager.getImage(this.iImageID).getHeight()
               + iTranslateY,
            (int)((float)ImageManager.getImage(this.iImageID).getWidth() * this.getImageScale()),
            (int)((float)ImageManager.getImage(this.iImageID).getHeight() * this.getImageScale())
         );
      CFG.fontMain.getData().setScale(0.7F);
      CFG.drawTextWithShadow(
         oSB,
         this.getTextToDraw(),
         this.getPosX() + this.getTextPos() + CFG.PADDING + (int)((float)ImageManager.getImage(this.iImageID).getWidth() * this.getImageScale()) + iTranslateX,
         this.getPosY() + this.getHeight() / 2 - (int)((float)this.iTextHeight * 0.7F / 2.0F) + iTranslateY,
         this.getColor(isActive)
      );
      CFG.fontMain.getData().setScale(1.0F);

      try {
         oSB.flush();
         ScissorStack.popScissors();
      } catch (IllegalStateException var7) {
      }
   }

   private final float getImageScale() {
      return (float)CFG.TEXT_HEIGHT / (float)ImageManager.getImage(this.iImageID).getHeight() < 1.0F
         ? (float)CFG.TEXT_HEIGHT / (float)ImageManager.getImage(this.iImageID).getHeight()
         : 1.0F;
   }
}
