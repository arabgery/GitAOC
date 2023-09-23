/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Game_Calendar;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuElement;
import age.of.civilizations2.jakowski.lukasz.MenuElement_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.MenuElement_Hover_v2_Element2;
import age.of.civilizations2.jakowski.lukasz.MenuElement_Hover_v2_Element_Type;
import age.of.civilizations2.jakowski.lukasz.MenuElement_Hover_v2_Element_Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuElement_Hover_v2_Element_Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuElement_Hover_v2_Element_Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuElement_Hover_v2_Element_Type_Text;
import age.of.civilizations2.jakowski.lukasz.SliderMenu;
import age.of.civilizations2.jakowski.lukasz.Text_ActionInfo_Cost_Right;
import age.of.civilizations2.jakowski.lukasz.Text_ActionInfo_Cost_Right_Balance;
import age.of.civilizations2.jakowski.lukasz.Text_ActionInfo_Move;
import age.of.civilizations2.jakowski.lukasz.Text_ActionInfo_MovementCost_Right;
import age.of.civilizations2.jakowski.lukasz.Text_ActionInfo_RecruitInstantly;
import age.of.civilizations2.jakowski.lukasz.Text_ActionInfo_Turns;
import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;

class Menu_InGame_ActionInfo_Recruit
extends SliderMenu {
    protected Menu_InGame_ActionInfo_Recruit() {
        ArrayList<MenuElement> menuElements = new ArrayList<MenuElement>();
        menuElements.add(new Text_ActionInfo_Move("", 0 + AoCGame.LEFT, CFG.GAME_HEIGHT - CFG.map.getMapBG().getMinimapHeight() - CFG.PADDING - (CFG.TEXT_HEIGHT + CFG.PADDING * 2) - CFG.BUTTON_HEIGHT - CFG.PADDING * 2){

            @Override
            protected Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_POPULATION_ACTIVE : (this.getIsHovered() ? CFG.COLOR_TEXT_POPULATION_HOVER : CFG.COLOR_TEXT_POPULATION);
            }

            @Override
            protected void buildElementHover() {
                ArrayList<MenuElement_Hover_v2_Element2> nElements = new ArrayList<MenuElement_Hover_v2_Element2>();
                ArrayList<MenuElement_Hover_v2_Element_Type> nData = new ArrayList<MenuElement_Hover_v2_Element_Type>();
                nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("ArmyRecruitmentWillTakeOneTurn"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MenuElement_Hover_v2_Element2(nData));
                nData.clear();
                nData.add(new MenuElement_Hover_v2_Element_Type_Text(Game_Calendar.getDate_ByTurnID(Game_Calendar.TURN_ID + 1)));
                nData.add(new MenuElement_Hover_v2_Element_Type_Image(Images.time, CFG.PADDING, 0));
                nElements.add(new MenuElement_Hover_v2_Element2(nData));
                nData.clear();
                this.menuElementHover = new MenuElement_Hover_v2(nElements);
            }
        });
        menuElements.add(new Text_ActionInfo_MovementCost_Right("-" + (float)CFG.ideologiesManager.getIdeology((int)CFG.game.getCiv((int)CFG.game.getPlayer((int)CFG.PLAYER_TURNID).getCivID()).getIdeologyID()).COST_OF_RECRUIT / 10.0f, 0, CFG.GAME_HEIGHT - CFG.map.getMapBG().getMinimapHeight() - CFG.PADDING - (CFG.TEXT_HEIGHT + CFG.PADDING * 2) * 2 - CFG.PADDING - CFG.BUTTON_HEIGHT - CFG.PADDING * 2){

            @Override
            protected void buildElementHover() {
                ArrayList<MenuElement_Hover_v2_Element2> nElements = new ArrayList<MenuElement_Hover_v2_Element2>();
                ArrayList<MenuElement_Hover_v2_Element_Type> nData = new ArrayList<MenuElement_Hover_v2_Element_Type>();
                nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("Cost") + ": "));
                nData.add(new MenuElement_Hover_v2_Element_Type_Text("" + (float)CFG.ideologiesManager.getIdeology((int)CFG.game.getCiv((int)CFG.game.getPlayer((int)CFG.PLAYER_TURNID).getCivID()).getIdeologyID()).COST_OF_RECRUIT / 10.0f, CFG.COLOR_INGAME_MOVEMENT));
                nData.add(new MenuElement_Hover_v2_Element_Type_Image(Images.top_movement_points, CFG.PADDING, 0));
                nElements.add(new MenuElement_Hover_v2_Element2(nData));
                nData.clear();
                this.menuElementHover = new MenuElement_Hover_v2(nElements);
            }
        });
        menuElements.add(new Text_ActionInfo_Cost_Right("", 0, CFG.GAME_HEIGHT - CFG.map.getMapBG().getMinimapHeight() - CFG.PADDING - (CFG.TEXT_HEIGHT + CFG.PADDING * 2) - CFG.BUTTON_HEIGHT - CFG.PADDING * 2){

            @Override
            protected Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_INGAME_GOLD_ACTIVE : (this.getIsHovered() ? CFG.COLOR_INGAME_GOLD_HOVER : CFG.COLOR_INGAME_GOLD);
            }

            @Override
            protected void buildElementHover() {
                ArrayList<MenuElement_Hover_v2_Element2> nElements = new ArrayList<MenuElement_Hover_v2_Element2>();
                ArrayList<MenuElement_Hover_v2_Element_Type> nData = new ArrayList<MenuElement_Hover_v2_Element_Type>();
                nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("OneUnitCostsXGold", CFG.getCostOfRecruitArmyMoney(CFG.game.getActiveProvinceID())), CFG.COLOR_BUTTON_GAME_TEXT_ACTIVE));
                nData.add(new MenuElement_Hover_v2_Element_Type_Image(Images.top_gold, CFG.PADDING, 0));
                nElements.add(new MenuElement_Hover_v2_Element2(nData));
                nData.clear();
                this.menuElementHover = new MenuElement_Hover_v2(nElements);
            }
        });
        menuElements.add(new Text_ActionInfo_Turns("1 " + CFG.langManager.get("Turn"), 0 + AoCGame.LEFT, CFG.GAME_HEIGHT - CFG.map.getMapBG().getMinimapHeight() - CFG.PADDING - (CFG.TEXT_HEIGHT + CFG.PADDING * 2) * 2 - CFG.PADDING - CFG.BUTTON_HEIGHT - CFG.PADDING * 2){

            @Override
            protected void buildElementHover() {
                ArrayList<MenuElement_Hover_v2_Element2> nElements = new ArrayList<MenuElement_Hover_v2_Element2>();
                ArrayList<MenuElement_Hover_v2_Element_Type> nData = new ArrayList<MenuElement_Hover_v2_Element_Type>();
                nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("ArmyRecruitmentWillTakeOneTurn"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MenuElement_Hover_v2_Element2(nData));
                nData.clear();
                nData.add(new MenuElement_Hover_v2_Element_Type_Text(Game_Calendar.getDate_ByTurnID(Game_Calendar.TURN_ID + 1)));
                nData.add(new MenuElement_Hover_v2_Element_Type_Image(Images.time, CFG.PADDING, 0));
                nElements.add(new MenuElement_Hover_v2_Element2(nData));
                nData.clear();
                this.menuElementHover = new MenuElement_Hover_v2(nElements);
            }
        });
        menuElements.add(new Text_ActionInfo_RecruitInstantly(CFG.langManager.get("Conscript"), 0 + AoCGame.LEFT, CFG.GAME_HEIGHT - CFG.map.getMapBG().getMinimapHeight() - CFG.PADDING - (CFG.TEXT_HEIGHT + CFG.PADDING * 2) * 3 - CFG.PADDING - CFG.PADDING - CFG.BUTTON_HEIGHT - CFG.PADDING * 2){

            @Override
            protected void buildElementHover() {
                ArrayList<MenuElement_Hover_v2_Element2> nElements = new ArrayList<MenuElement_Hover_v2_Element2>();
                ArrayList<MenuElement_Hover_v2_Element_Type> nData = new ArrayList<MenuElement_Hover_v2_Element_Type>();
                nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("RecruitArmyInstantly"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new MenuElement_Hover_v2_Element_Type_Flag(CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID(), CFG.PADDING, 0));
                nElements.add(new MenuElement_Hover_v2_Element2(nData));
                nData.clear();
                nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("CostOfRecruitingWillBeDoubled"), CFG.COLOR_TEXT_MODIFIER_NEGATIVE2));
                nElements.add(new MenuElement_Hover_v2_Element2(nData));
                nData.clear();
                nData.add(new MenuElement_Hover_v2_Element_Type_Space());
                nElements.add(new MenuElement_Hover_v2_Element2(nData));
                nData.clear();
                nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("OneUnitCostsXGold", CFG.getCostOfRecruitArmyMoney_Instantly(BuildingsManager.iBuildInProvinceID)), CFG.COLOR_BUTTON_GAME_TEXT_ACTIVE));
                nData.add(new MenuElement_Hover_v2_Element_Type_Image(Images.top_gold, CFG.PADDING, 0));
                nElements.add(new MenuElement_Hover_v2_Element2(nData));
                nData.clear();
                nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("Cost") + ": "));
                nData.add(new MenuElement_Hover_v2_Element_Type_Text("" + (float)CFG.ideologiesManager.getIdeology((int)CFG.game.getCiv((int)CFG.game.getPlayer((int)CFG.PLAYER_TURNID).getCivID()).getIdeologyID()).COST_OF_RECRUIT / 10.0f, CFG.COLOR_INGAME_MOVEMENT));
                nData.add(new MenuElement_Hover_v2_Element_Type_Image(Images.top_movement_points, CFG.PADDING, 0));
                nElements.add(new MenuElement_Hover_v2_Element2(nData));
                nData.clear();
                this.menuElementHover = new MenuElement_Hover_v2(nElements);
            }
        });
        menuElements.add(new Text_ActionInfo_Cost_Right_Balance(CFG.langManager.get("Balance") + ": ", 0, CFG.GAME_HEIGHT - CFG.map.getMapBG().getMinimapHeight() - CFG.PADDING - (CFG.TEXT_HEIGHT + CFG.PADDING * 2) * 3 - CFG.PADDING * 2 - CFG.BUTTON_HEIGHT - CFG.PADDING * 2){});
        this.initMenu(null, 0, 0, CFG.GAME_WIDTH, CFG.GAME_HEIGHT, menuElements, false, false);
    }

    @Override
    protected final void actionElement(int iID) {
        switch (iID) {
            case 0: {
                break;
            }
            case 1: {
                CFG.toast.setInView(CFG.langManager.get("MovementPoints") + ": " + this.getMenuElement(1).getText(), CFG.COLOR_INGAME_MOVEMENT_ZERO);
                return;
            }
            case 2: {
                break;
            }
            case 4: {
                CFG.menuManager.setVisible_InGame_ProvinceRecruit(false);
                if (CFG.game.getActiveProvinceID() >= 0) {
                    if (CFG.game.getProvince(CFG.game.getActiveProvinceID()).getTrueOwnerOfProvince() == CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID()) {
                        CFG.game.setActiveProvinceID(CFG.game.getActiveProvinceID());
                        if (CFG.game.getCiv(CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID()).getMovePoints() < CFG.ideologiesManager.getIdeology((int)CFG.game.getCiv((int)CFG.game.getPlayer((int)CFG.PLAYER_TURNID).getCivID()).getIdeologyID()).COST_OF_RECRUIT) {
                            CFG.menuManager.setVisible_InGame_ActionInfo_NoMovementPoints();
                        } else if (CFG.game.getCiv(CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID()).getMoney() < (long)CFG.getCostOfRecruitArmyMoney_Instantly(CFG.game.getActiveProvinceID())) {
                            CFG.menuManager.setVisible_InGame_ActionInfo_TreasuryIsEmpty();
                        } else {
                            CFG.game.resetChooseProvinceData();
                            CFG.menuManager.setVisible_InGame_ProvinceAction(false);
                            CFG.gameAction.updateRecruitSlider_Instantly();
                            CFG.menuManager.setVisible_InGame_ProvinceRecruitInstantly(true);
                            CFG.menuManager.setVisible_InGame_ActionInfo_RecruitInstantly();
                            CFG.toast.setInView(CFG.langManager.get("CostOfRecruitingWillBeDoubled"), CFG.COLOR_TEXT_MODIFIER_NEGATIVE2);
                        }
                    } else {
                        CFG.menuManager.setVisible_InGame_ActionInfo_RecruitOccupied();
                    }
                }
                return;
            }
            case 5: {
                this.getMenuElement(iID).actionElement(iID);
                return;
            }
        }
        CFG.toast.setInView(this.getMenuElement(iID).getText(), CFG.COLOR_BUTTON_GAME_TEXT_ACTIVE);
    }

    @Override
    protected void onHovered() {
        CFG.menuManager.setOrderOfMenu_InGame_Recruit();
    }
}

