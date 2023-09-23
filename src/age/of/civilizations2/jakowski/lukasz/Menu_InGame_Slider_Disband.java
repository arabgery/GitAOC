/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Button_Game_Accept;
import age.of.civilizations2.jakowski.lukasz.Button_Game_Decline;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.ImageManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuElement;
import age.of.civilizations2.jakowski.lukasz.Menu_InGame;
import age.of.civilizations2.jakowski.lukasz.RTS;
import age.of.civilizations2.jakowski.lukasz.SliderMenu;
import age.of.civilizations2.jakowski.lukasz.Slider_LR_Perc;
import age.of.civilizations2.jakowski.lukasz.ViewsManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

class Menu_InGame_Slider_Disband
extends SliderMenu {
    protected Menu_InGame_Slider_Disband() {
        ArrayList<MenuElement> menuElements = new ArrayList<MenuElement>();
        menuElements.add(new Button_Game_Decline(CFG.PADDING, CFG.PADDING, true));
        menuElements.add(new Button_Game_Accept(CFG.GAME_WIDTH - CFG.PADDING - CFG.BUTTON_WIDTH, CFG.PADDING, true));
        menuElements.add(new Slider_LR_Perc(CFG.BUTTON_WIDTH + CFG.PADDING * 2, CFG.PADDING, CFG.GAME_WIDTH - CFG.BUTTON_WIDTH * 2 - CFG.PADDING * 4, CFG.BUTTON_HEIGHT, 0, 200, 100){

            @Override
            protected Color getColorLEFT() {
                return CFG.COLOR_SLIDER_LEFT_BG3;
            }
        });
        this.initMenu(null, 0, CFG.GAME_HEIGHT - CFG.map.getMapBG().getMinimapHeight() - CFG.BUTTON_HEIGHT - CFG.PADDING * 2, CFG.GAME_WIDTH, CFG.BUTTON_HEIGHT + CFG.PADDING * 2, menuElements, false, false);
        this.updateLanguage();
        CFG.fMOVE_MENU_PERCENTAGE = 5.0f;
        CFG.lMOVE_MENU_TIME = System.currentTimeMillis();
    }

    @Override
    protected void updateLanguage() {
    }

    @Override
    protected void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if ((CFG.fMOVE_MENU_PERCENTAGE += (float)(System.currentTimeMillis() - CFG.lMOVE_MENU_TIME) / 250.0f * 95.0f) > 100.0f) {
            CFG.fMOVE_MENU_PERCENTAGE = 100.0f;
        } else {
            CFG.setRender_3(true);
        }
        CFG.lMOVE_MENU_TIME = System.currentTimeMillis();
        Rectangle clipBounds = new Rectangle(this.getPosX() + iTranslateX, CFG.GAME_HEIGHT - this.getPosY() - iTranslateY, this.getWidth(), -this.getHeight());
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
        ImageManager.getImage(Images.bg_game_menu).draw2(oSB, this.getPosX() + iTranslateX, this.getPosY() - ImageManager.getImage(Images.bg_game_menu).getHeight() + (int)((float)this.getHeight() * (100.0f - CFG.fMOVE_MENU_PERCENTAGE) / 100.0f) + iTranslateY, this.getWidth(), this.getHeight());
        oSB.setColor(CFG.COLOR_BG_GAME_MENU_SHADOW);
        ImageManager.getImage(Images.pix255_255_255).draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeight() - 1 - ImageManager.getImage(Images.pix255_255_255).getHeight() + iTranslateY, this.getWidth(), 1);
        ImageManager.getImage(Images.line_32_off1).draw(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeight() - 1 - ImageManager.getImage(Images.line_32_off1).getHeight() + iTranslateY, this.getWidth(), 1);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, (int)((float)this.getHeight() * (100.0f - CFG.fMOVE_MENU_PERCENTAGE) / 100.0f) + iTranslateY, sliderMenuIsActive);
    }

    @Override
    protected void beginClip(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
    }

    @Override
    protected void extraAction() {
        block5: {
            try {
                CFG.menuManager.setVisible_InGame_ProvinceDisband(false);
                CFG.gameAction.disbandArmy(CFG.game.getActiveProvinceID(), this.getMenuElement(2).getCurrent(), CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID());
                CFG.game.checkProvinceActionMenu();
                CFG.menuManager.updateInGame_TOP_All(CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID());
                CFG.gameAction.updateInGame_ProvinceInfo();
                if (CFG.menuManager.getVisibleInGame_CensusOfProvince()) {
                    CFG.menuManager.rebuildInGame_CensusOfProvince(CFG.game.getActiveProvinceID());
                }
                if (CFG.viewsManager.getActiveViewID() == ViewsManager.VIEW_ARMY_MODE) {
                    CFG.updateMAX_Army();
                }
                CFG.game.getPlayer(CFG.PLAYER_TURNID).setNoOrders(false);
                Menu_InGame.updateOverBudget();
                if (RTS.isEnabled() && !RTS.PAUSE) {
                    RTS.updateTimePast_AfterAction(0.75f);
                }
            }
            catch (IndexOutOfBoundsException ex) {
                if (!CFG.LOGS) break block5;
                CFG.exceptionStack(ex);
            }
        }
    }

    @Override
    protected final void actionElement(int iID) {
        switch (iID) {
            case 0: {
                CFG.menuManager.setVisible_InGame_ProvinceDisband(false);
                CFG.game.checkProvinceActionMenu();
                if (!RTS.isEnabled() || RTS.PAUSE) break;
                RTS.updateTimePast_AfterAction(0.5f);
                break;
            }
            case 1: {
                this.extraAction();
                break;
            }
            case 2: {
                CFG.menuManager.updateInGame_ActionInfo_Disband();
            }
        }
    }

    @Override
    protected void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            CFG.fMOVE_MENU_PERCENTAGE = 5.0f;
            CFG.lMOVE_MENU_TIME = System.currentTimeMillis();
        }
    }

    @Override
    protected void onHovered() {
        CFG.menuManager.setOrderOfMenu_InGame_Recruit();
    }
}

