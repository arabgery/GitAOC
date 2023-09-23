/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.MenuElement;
import age.of.civilizations2.jakowski.lukasz.SliderMenu;
import age.of.civilizations2.jakowski.lukasz.Text_ActionInfo;
import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;

class Menu_InGame_ActionInfo_TreasuryIsEmpty
extends SliderMenu {
    protected Menu_InGame_ActionInfo_TreasuryIsEmpty() {
        ArrayList<MenuElement> menuElements = new ArrayList<MenuElement>();
        menuElements.add(new Text_ActionInfo(null, 0 + AoCGame.LEFT, CFG.GAME_HEIGHT - CFG.map.getMapBG().getMinimapHeight() - CFG.PADDING - (CFG.TEXT_HEIGHT + CFG.PADDING * 2) - CFG.BUTTON_HEIGHT - CFG.PADDING * 2){

            @Override
            protected Color getColor(boolean isActive) {
                return isActive || this.getIsHovered() ? CFG.COLOR_TEXT_MODIFIER_NEGATIVE : CFG.COLOR_TEXT_MODIFIER_NEGATIVE2;
            }
        });
        this.initMenu(null, 0, 0, CFG.GAME_WIDTH, CFG.GAME_HEIGHT, menuElements, false, false);
        this.updateLanguage();
    }

    @Override
    protected void updateLanguage() {
        this.getMenuElement(0).setText(CFG.langManager.get("TreasuryIsEmpty") + ".");
    }

    @Override
    protected final void actionElement(int iID) {
        switch (iID) {
            case 0: {
                this.setVisible(false);
            }
        }
    }

    @Override
    protected void onHovered() {
        CFG.menuManager.setOrderOfMenu_InGame_Recruit();
    }
}

