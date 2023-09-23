package age.of.civilizations2.jakowski.lukasz;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;
import java.util.List;

class Button_PeaceTreaty_Demands_ReleaseVassal extends Button {
   protected static final float TEXT_SCALE = 0.7F;
   protected int iCivID = 0;
   protected int iReleaseCivID = 0;
   protected int toReleaseByCivID = 0;
   protected boolean row = false;
   protected String sValue;
   protected int iValueWidth = 0;
   protected static int MAX_WDITH_LEFT = 0;

   protected Button_PeaceTreaty_Demands_ReleaseVassal(
      int nCivID, int iReleaseCivID, int toReleaseByCivID, int costRelease, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable
   ) {
      super.init(CFG.game.getCiv(iReleaseCivID).getCivName(), 0, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false);
      this.iCivID = nCivID;
      this.iReleaseCivID = iReleaseCivID;
      this.toReleaseByCivID = toReleaseByCivID;
      this.sValue = "" + costRelease;
      CFG.glyphLayout.setText(CFG.fontMain, this.sValue);
      this.iValueWidth = (int)(CFG.glyphLayout.width * 0.7F);
      MAX_WDITH_LEFT = Math.max(
            (int)((float)ImageManager.getImage(Images.city).getWidth() * this.getImageScale(ImageManager.getImage(Images.city).getHeight())),
            (int)((float)ImageManager.getImage(Images.flag_rect).getWidth() * this.getImageScale2(Images.flag_rect))
         )
         + CFG.PADDING * 4;
   }

   @Override
   protected void drawButtonBG(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
      oSB.setColor(new Color(0.0F, 0.0F, 0.0F, 0.275F));
      ImageManager.getImage(Images.pix255_255_255)
         .draw(
            oSB,
            this.getPosX() + iTranslateX,
            this.getPosY() - ImageManager.getImage(Images.pix255_255_255).getHeight() + iTranslateY,
            MAX_WDITH_LEFT,
            this.getHeight()
         );
      oSB.setColor(
         new Color(
            (float)CFG.game.getCiv(this.iReleaseCivID).getR() / 255.0F,
            (float)CFG.game.getCiv(this.iReleaseCivID).getG() / 255.0F,
            (float)CFG.game.getCiv(this.iReleaseCivID).getB() / 255.0F,
            0.125F
         )
      );
      ImageManager.getImage(Images.slider_gradient)
         .draw(
            oSB,
            this.getPosX() + iTranslateX,
            this.getPosY() - ImageManager.getImage(Images.slider_gradient).getHeight() + iTranslateY,
            MAX_WDITH_LEFT * 3 / 4,
            this.getHeight()
         );
      if (this.row) {
         oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.4F));
         ImageManager.getImage(Images.slider_gradient)
            .draw(
               oSB,
               this.getPosX() + iTranslateX,
               this.getPosY() - ImageManager.getImage(Images.slider_gradient).getHeight() + iTranslateY,
               this.getWidth() / 2,
               this.getHeight()
            );
         ImageManager.getImage(Images.slider_gradient)
            .draw(
               oSB,
               this.getPosX() + this.getWidth() - this.getWidth() / 2 + iTranslateX,
               this.getPosY() - ImageManager.getImage(Images.slider_gradient).getHeight() + iTranslateY,
               this.getWidth() / 2,
               this.getHeight(),
               true,
               false
            );
         oSB.setColor(new Color(CFG.COLOR_INFO_BOX_GRADIENT.r, CFG.COLOR_INFO_BOX_GRADIENT.g, CFG.COLOR_INFO_BOX_GRADIENT.b, 0.35F));
         ImageManager.getImage(Images.gradient)
            .draw(
               oSB,
               this.getPosX() + iTranslateX,
               this.getPosY() - ImageManager.getImage(Images.gradient).getHeight() + iTranslateY,
               this.getWidth(),
               this.getHeight() / 4
            );
         ImageManager.getImage(Images.gradient)
            .draw(
               oSB,
               this.getPosX() + iTranslateX,
               this.getPosY() + this.getHeight() - this.getHeight() / 4 - ImageManager.getImage(Images.gradient).getHeight() + iTranslateY,
               this.getWidth(),
               this.getHeight() / 4,
               false,
               true
            );
         oSB.setColor(new Color(0.0F, 0.0F, 0.0F, 0.6F));
         ImageManager.getImage(Images.line_32_off1)
            .draw(
               oSB,
               this.getPosX() + iTranslateX,
               this.getPosY() + this.getHeight() - 1 - ImageManager.getImage(Images.line_32_off1).getHeight() + iTranslateY,
               this.getWidth(),
               1
            );
         ImageManager.getImage(Images.line_32_off1)
            .draw(oSB, this.getPosX() + iTranslateX, this.getPosY() - ImageManager.getImage(Images.line_32_off1).getHeight() + iTranslateY, this.getWidth(), 1);
         if (isActive || this.getIsHovered()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.35F));
            ImageManager.getImage(Images.slider_gradient)
               .draw(
                  oSB,
                  this.getPosX() + iTranslateX,
                  this.getPosY() + 1 - ImageManager.getImage(Images.slider_gradient).getHeight() + iTranslateY,
                  this.getWidth(),
                  this.getHeight() - 2,
                  true,
                  false
               );
         }
      } else {
         oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.6F));
         ImageManager.getImage(Images.slider_gradient)
            .draw(
               oSB,
               this.getPosX() + iTranslateX,
               this.getPosY() - ImageManager.getImage(Images.slider_gradient).getHeight() + iTranslateY,
               this.getWidth() / 2,
               this.getHeight()
            );
         ImageManager.getImage(Images.slider_gradient)
            .draw(
               oSB,
               this.getPosX() + this.getWidth() - this.getWidth() / 2 + iTranslateX,
               this.getPosY() - ImageManager.getImage(Images.slider_gradient).getHeight() + iTranslateY,
               this.getWidth() / 2,
               this.getHeight(),
               true,
               false
            );
         oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.45F));
         ImageManager.getImage(Images.gradient)
            .draw(
               oSB,
               this.getPosX() + iTranslateX,
               this.getPosY() - ImageManager.getImage(Images.gradient).getHeight() + iTranslateY,
               this.getWidth(),
               this.getHeight() / 4
            );
         ImageManager.getImage(Images.gradient)
            .draw(
               oSB,
               this.getPosX() + iTranslateX,
               this.getPosY() + this.getHeight() - this.getHeight() / 4 - ImageManager.getImage(Images.gradient).getHeight() + iTranslateY,
               this.getWidth(),
               this.getHeight() / 4,
               false,
               true
            );
         oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.85F));
         ImageManager.getImage(Images.line_32_off1)
            .draw(
               oSB,
               this.getPosX() + iTranslateX,
               this.getPosY() + this.getHeight() - 1 - ImageManager.getImage(Images.line_32_off1).getHeight() + iTranslateY,
               this.getWidth(),
               1
            );
         ImageManager.getImage(Images.line_32_off1)
            .draw(oSB, this.getPosX() + iTranslateX, this.getPosY() - ImageManager.getImage(Images.line_32_off1).getHeight() + iTranslateY, this.getWidth(), 1);
         if (isActive || this.getIsHovered()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.45F));
            ImageManager.getImage(Images.slider_gradient)
               .draw(
                  oSB,
                  this.getPosX() + iTranslateX,
                  this.getPosY() + 1 - ImageManager.getImage(Images.slider_gradient).getHeight() + iTranslateY,
                  this.getWidth(),
                  this.getHeight() - 2,
                  true,
                  false
               );
         }
      }

      oSB.setColor(Color.WHITE);
   }

   protected final float getImageScale(int nHeight) {
      return (float)CFG.TEXT_HEIGHT * 0.8F / (float)nHeight;
   }

   protected final float getImageScale2(int nImageID) {
      return (float)CFG.TEXT_HEIGHT / (float)ImageManager.getImage(nImageID).getHeight() < 1.0F
         ? (float)CFG.TEXT_HEIGHT / (float)ImageManager.getImage(nImageID).getHeight()
         : 1.0F;
   }

   @Override
   protected void drawText(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
      oSB.setColor(new Color(0.0F, 0.0F, 0.0F, 0.375F));
      ImageManager.getImage(Images.line_32_vertical)
         .draw(
            oSB,
            this.getPosX() - 1 + MAX_WDITH_LEFT + iTranslateX,
            this.getPosY() + CFG.PADDING - ImageManager.getImage(Images.line_32_vertical).getHeight() + iTranslateY,
            1,
            this.getHeight() - CFG.PADDING * 2
         );
      ImageManager.getImage(Images.line_32_vertical)
         .draw(
            oSB,
            this.getPosX() + 1 + MAX_WDITH_LEFT + iTranslateX,
            this.getPosY() + CFG.PADDING - ImageManager.getImage(Images.line_32_vertical).getHeight() + iTranslateY,
            1,
            this.getHeight() - CFG.PADDING * 2
         );
      ImageManager.getImage(Images.line_32_vertical)
         .draw(
            oSB,
            this.getPosX() + this.getWidth() - 1 - 1 + iTranslateX,
            this.getPosY() + CFG.PADDING - ImageManager.getImage(Images.line_32_vertical).getHeight() + iTranslateY,
            1,
            this.getHeight() - CFG.PADDING * 2
         );
      ImageManager.getImage(Images.line_32_vertical)
         .draw(
            oSB,
            this.getPosX() + this.getWidth() - 1 + 1 + iTranslateX,
            this.getPosY() + CFG.PADDING - ImageManager.getImage(Images.line_32_vertical).getHeight() + iTranslateY,
            1,
            this.getHeight() - CFG.PADDING * 2
         );
      oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.875F));
      ImageManager.getImage(Images.line_32_vertical)
         .draw(
            oSB,
            this.getPosX() + MAX_WDITH_LEFT + iTranslateX,
            this.getPosY() - ImageManager.getImage(Images.line_32_vertical).getHeight() + iTranslateY,
            1,
            this.getHeight()
         );
      ImageManager.getImage(Images.line_32_vertical)
         .draw(
            oSB,
            this.getPosX() + this.getWidth() - 1 + iTranslateX,
            this.getPosY() - ImageManager.getImage(Images.line_32_vertical).getHeight() + iTranslateY,
            1,
            this.getHeight()
         );
      oSB.setColor(Color.WHITE);

      try {
         if (this.iCivID > 0) {
            CFG.game
               .getCiv(this.iCivID)
               .getFlag()
               .draw(
                  oSB,
                  this.getPosX()
                     + MAX_WDITH_LEFT / 2
                     - (int)((float)ImageManager.getImage(Images.flag_rect).getWidth() * this.getImageScale2(Images.flag_rect)) / 2
                     + iTranslateX,
                  this.getPosY()
                     + this.getHeight() / 2
                     - (int)((float)ImageManager.getImage(Images.flag_rect).getHeight() * this.getImageScale2(Images.flag_rect)) / 2
                     - CFG.game.getCiv(this.iCivID).getFlag().getHeight()
                     + iTranslateY,
                  (int)((float)ImageManager.getImage(Images.flag_rect).getWidth() * this.getImageScale2(Images.flag_rect)),
                  (int)((float)ImageManager.getImage(Images.flag_rect).getHeight() * this.getImageScale2(Images.flag_rect))
               );
            ImageManager.getImage(Images.flag_rect)
               .draw(
                  oSB,
                  this.getPosX()
                     + MAX_WDITH_LEFT / 2
                     - (int)((float)ImageManager.getImage(Images.flag_rect).getWidth() * this.getImageScale2(Images.flag_rect)) / 2
                     + iTranslateX,
                  this.getPosY()
                     + this.getHeight() / 2
                     - (int)((float)ImageManager.getImage(Images.flag_rect).getHeight() * this.getImageScale2(Images.flag_rect)) / 2
                     - ImageManager.getImage(Images.flag_rect).getHeight()
                     + iTranslateY,
                  (int)((float)ImageManager.getImage(Images.flag_rect).getWidth() * this.getImageScale2(Images.flag_rect)),
                  (int)((float)ImageManager.getImage(Images.flag_rect).getHeight() * this.getImageScale2(Images.flag_rect))
               );
         } else {
            ImageManager.getImage(Images.diplo_vassal)
               .draw(
                  oSB,
                  this.getPosX()
                     + MAX_WDITH_LEFT / 2
                     - (int)(
                           (float)ImageManager.getImage(Images.diplo_vassal).getWidth()
                              * this.getImageScale(ImageManager.getImage(Images.diplo_vassal).getHeight())
                        )
                        / 2
                     + iTranslateX,
                  this.getPosY()
                     + 1
                     + this.getHeight() / 2
                     - (int)(
                           (float)ImageManager.getImage(Images.diplo_vassal).getHeight()
                              * this.getImageScale(ImageManager.getImage(Images.diplo_vassal).getHeight())
                        )
                        / 2
                     - ImageManager.getImage(Images.diplo_vassal).getHeight()
                     + iTranslateY,
                  (int)(
                     (float)ImageManager.getImage(Images.diplo_vassal).getWidth() * this.getImageScale(ImageManager.getImage(Images.diplo_vassal).getHeight())
                  ),
                  (int)(
                     (float)ImageManager.getImage(Images.diplo_vassal).getHeight()
                        * this.getImageScale(ImageManager.getImage(Images.diplo_vassal).getHeight())
                  )
               );
         }
      } catch (IndexOutOfBoundsException var8) {
      } catch (NullPointerException var9) {
      }

      ImageManager.getImage(Images.victoryPoints)
         .draw(
            oSB,
            this.getPosX()
               + this.getWidth()
               - CFG.PADDING * 2
               - (int)(
                  (float)ImageManager.getImage(Images.victoryPoints).getWidth() * this.getImageScale(ImageManager.getImage(Images.victoryPoints).getHeight())
               )
               + iTranslateX,
            this.getPosY()
               + 1
               + this.getHeight() / 2
               - (int)(
                     (float)ImageManager.getImage(Images.victoryPoints).getHeight()
                        * this.getImageScale(ImageManager.getImage(Images.victoryPoints).getHeight())
                  )
                  / 2
               + iTranslateY
               - ImageManager.getImage(Images.victoryPoints).getHeight(),
            (int)((float)ImageManager.getImage(Images.victoryPoints).getWidth() * this.getImageScale(ImageManager.getImage(Images.victoryPoints).getHeight())),
            (int)((float)ImageManager.getImage(Images.victoryPoints).getHeight() * this.getImageScale(ImageManager.getImage(Images.victoryPoints).getHeight()))
         );
      Rectangle clipBounds = new Rectangle(
         (float)(this.getPosX() + iTranslateX),
         (float)(CFG.GAME_HEIGHT - this.getPosY() - iTranslateY),
         (float)(
            this.getWidth()
               - CFG.PADDING * 3
               - this.iValueWidth
               - (int)(
                  (float)ImageManager.getImage(Images.victoryPoints).getWidth() * this.getImageScale(ImageManager.getImage(Images.victoryPoints).getHeight())
               )
         ),
         (float)(-this.getHeight())
      );
      oSB.flush();
      ScissorStack.pushScissors(clipBounds);
      CFG.game
         .getCiv(this.iReleaseCivID)
         .getFlag()
         .draw(
            oSB,
            this.getPosX() + MAX_WDITH_LEFT + CFG.PADDING * 2 + iTranslateX,
            this.getPosY()
               + this.getHeight() / 2
               - (int)((float)ImageManager.getImage(Images.flag_rect).getHeight() * this.getImageScale2(Images.flag_rect)) / 2
               - CFG.game.getCiv(this.iReleaseCivID).getFlag().getHeight()
               + iTranslateY,
            (int)((float)ImageManager.getImage(Images.flag_rect).getWidth() * this.getImageScale2(Images.flag_rect)),
            (int)((float)ImageManager.getImage(Images.flag_rect).getHeight() * this.getImageScale2(Images.flag_rect))
         );
      ImageManager.getImage(Images.flag_rect)
         .draw(
            oSB,
            this.getPosX() + MAX_WDITH_LEFT + CFG.PADDING * 2 + iTranslateX,
            this.getPosY()
               + this.getHeight() / 2
               - (int)((float)ImageManager.getImage(Images.flag_rect).getHeight() * this.getImageScale2(Images.flag_rect)) / 2
               - ImageManager.getImage(Images.flag_rect).getHeight()
               + iTranslateY,
            (int)((float)ImageManager.getImage(Images.flag_rect).getWidth() * this.getImageScale2(Images.flag_rect)),
            (int)((float)ImageManager.getImage(Images.flag_rect).getHeight() * this.getImageScale2(Images.flag_rect))
         );
      CFG.fontMain.getData().setScale(0.7F);
      CFG.drawText(
         oSB,
         this.getText(),
         this.getPosX()
            + MAX_WDITH_LEFT
            + CFG.PADDING * 3
            + (int)((float)ImageManager.getImage(Images.flag_rect).getWidth() * this.getImageScale2(Images.flag_rect))
            + iTranslateX,
         this.getPosY() + this.getHeight() / 2 - (int)((float)this.getTextHeight() * 0.7F / 2.0F) + iTranslateY,
         this.getColor(isActive)
      );

      try {
         oSB.flush();
         ScissorStack.popScissors();
      } catch (IllegalStateException var7) {
      }

      CFG.drawText(
         oSB,
         this.sValue,
         this.getPosX()
            + this.getWidth()
            - CFG.PADDING * 3
            - this.iValueWidth
            - (int)(
               (float)ImageManager.getImage(Images.victoryPoints).getWidth() * this.getImageScale(ImageManager.getImage(Images.victoryPoints).getHeight())
            )
            + iTranslateX,
         this.getPosY() + this.getHeight() / 2 - (int)((float)this.getTextHeight() * 0.7F / 2.0F) + iTranslateY,
         CFG.COLOR_TEXT_NUM_OF_PROVINCES
      );
      CFG.fontMain.getData().setScale(1.0F);
   }

   @Override
   protected Color getColor(boolean isActive) {
      return isActive
         ? CFG.COLOR_TEXT_OPTIONS_NS_ACTIVE
         : (
            this.getClickable()
               ? (this.getIsHovered() ? CFG.COLOR_TEXT_OPTIONS_NS_HOVER : CFG.COLOR_TEXT_OPTIONS_LEFT_NS)
               : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE
         );
   }

   @Override
   protected void setCurrent(int nCurrent) {
      this.row = nCurrent == 1;
   }

   @Override
   protected void buildElementHover() {
      List<MenuElement_Hover_v2_Element2> nElements = new ArrayList<>();
      List<MenuElement_Hover_v2_Element_Type> nData = new ArrayList<>();
      if (this.iCivID > 0) {
         nData.add(new MenuElement_Hover_v2_Element_Type_Flag(this.iCivID));
      }

      nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("ReleaseAVassal") + ":"));
      nData.add(new MenuElement_Hover_v2_Element_Type_Flag(this.iReleaseCivID, CFG.PADDING, CFG.PADDING));
      nData.add(new MenuElement_Hover_v2_Element_Type_Text(this.getText(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
      nData.add(new MenuElement_Hover_v2_Element_Type_Image(Images.diplo_vassal, CFG.PADDING, 0));
      nElements.add(new MenuElement_Hover_v2_Element2(nData));
      nData.clear();

      for(int i = 0; i < CFG.peaceTreatyData.peaceTreatyGameData.lCivsDemands_Defenders.size(); ++i) {
         if (CFG.peaceTreatyData.peaceTreatyGameData.lCivsDemands_Defenders.get(i).iCivID == this.toReleaseByCivID) {
            for(int j = 0; j < CFG.peaceTreatyData.peaceTreatyGameData.lCivsDemands_Defenders.get(i).lReleasableCivs.size(); ++j) {
               if (CFG.peaceTreatyData.peaceTreatyGameData.lCivsDemands_Defenders.get(i).lReleasableCivs.get(j).iCivID == this.iReleaseCivID) {
                  for(int k = 0;
                     k < CFG.peaceTreatyData.peaceTreatyGameData.lCivsDemands_Defenders.get(i).lReleasableCivs.get(j).lProvinces.size() && k < 8;
                     ++k
                  ) {
                     nData.add(new MenuElement_Hover_v2_Element_Type_Flag(this.iReleaseCivID));
                     nData.add(
                        new MenuElement_Hover_v2_Element_Type_Text(
                           CFG.game
                              .getProvince(CFG.peaceTreatyData.peaceTreatyGameData.lCivsDemands_Defenders.get(i).lReleasableCivs.get(j).lProvinces.get(k))
                              .getName(),
                           CFG.COLOR_TEXT_MODIFIER_NEUTRAL
                        )
                     );
                     nData.add(
                        new MenuElement_Hover_v2_Element_Type_Text(
                           " "
                              + CFG.game
                                 .getProvinceValue(
                                    CFG.peaceTreatyData.peaceTreatyGameData.lCivsDemands_Defenders.get(i).lReleasableCivs.get(j).lProvinces.get(k)
                                 ),
                           CFG.COLOR_TEXT_NUM_OF_PROVINCES
                        )
                     );
                     nData.add(new MenuElement_Hover_v2_Element_Type_Image(Images.victoryPoints, CFG.PADDING, 0));
                     nElements.add(new MenuElement_Hover_v2_Element2(nData));
                     nData.clear();
                  }
               }
            }
         }
      }

      for(int i = 0; i < CFG.peaceTreatyData.peaceTreatyGameData.lCivsDemands_Aggressors.size(); ++i) {
         if (CFG.peaceTreatyData.peaceTreatyGameData.lCivsDemands_Aggressors.get(i).iCivID == this.toReleaseByCivID) {
            for(int j = 0; j < CFG.peaceTreatyData.peaceTreatyGameData.lCivsDemands_Aggressors.get(i).lReleasableCivs.size(); ++j) {
               if (CFG.peaceTreatyData.peaceTreatyGameData.lCivsDemands_Aggressors.get(i).lReleasableCivs.get(j).iCivID == this.iReleaseCivID) {
                  for(int k = 0;
                     k < CFG.peaceTreatyData.peaceTreatyGameData.lCivsDemands_Aggressors.get(i).lReleasableCivs.get(j).lProvinces.size() && k < 8;
                     ++k
                  ) {
                     nData.add(new MenuElement_Hover_v2_Element_Type_Flag(this.iReleaseCivID));
                     nData.add(
                        new MenuElement_Hover_v2_Element_Type_Text(
                           CFG.game
                              .getProvince(CFG.peaceTreatyData.peaceTreatyGameData.lCivsDemands_Aggressors.get(i).lReleasableCivs.get(j).lProvinces.get(k))
                              .getName(),
                           CFG.COLOR_TEXT_MODIFIER_NEUTRAL
                        )
                     );
                     nData.add(
                        new MenuElement_Hover_v2_Element_Type_Text(
                           " "
                              + CFG.game
                                 .getProvinceValue(
                                    CFG.peaceTreatyData.peaceTreatyGameData.lCivsDemands_Aggressors.get(i).lReleasableCivs.get(j).lProvinces.get(k)
                                 ),
                           CFG.COLOR_TEXT_NUM_OF_PROVINCES
                        )
                     );
                     nData.add(new MenuElement_Hover_v2_Element_Type_Image(Images.victoryPoints, CFG.PADDING, 0));
                     nElements.add(new MenuElement_Hover_v2_Element2(nData));
                     nData.clear();
                  }
               }
            }
         }
      }

      this.menuElementHover = new MenuElement_Hover_v2(nElements);
   }

   @Override
   protected void actionElement(int iID) {
      this.iCivID = CFG.peaceTreatyData.takeReleaseVassal(this.toReleaseByCivID, this.iReleaseCivID, CFG.peaceTreatyData.iBrushCivID, this.iCivID);
      if (CFG.menuManager.getInGame_PeaceTreaty()) {
         CFG.menuManager.rebuildInGame_PeaceTreaty_Scores();
      }

      if (this.iCivID > 0) {
         CFG.toast.setInView(CFG.langManager.get("ReleaseAVassal") + ": " + CFG.game.getCiv(this.iReleaseCivID).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
         CFG.toast.setTimeInView(1500);
      }
   }

   @Override
   protected void setMin(int iMin) {
      this.iCivID = iMin;
   }
}
