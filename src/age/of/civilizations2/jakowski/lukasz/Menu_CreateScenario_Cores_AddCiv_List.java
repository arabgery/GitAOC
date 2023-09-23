/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Button_Menu;
import age.of.civilizations2.jakowski.lukasz.Button_Menu_Classic_Wiki;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Dialog;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.ImageManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuElement;
import age.of.civilizations2.jakowski.lukasz.MenuElement_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.MenuElement_Hover_v2_Element2;
import age.of.civilizations2.jakowski.lukasz.MenuElement_Hover_v2_Element_Type;
import age.of.civilizations2.jakowski.lukasz.MenuElement_Hover_v2_Element_Type_Text;
import age.of.civilizations2.jakowski.lukasz.SliderMenu;
import age.of.civilizations2.jakowski.lukasz.Slider_BG;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;
import java.util.List;

class Menu_CreateScenario_Cores_AddCiv_List
extends SliderMenu {
    private List<String> lCivsTags = null;
    private List<Image> lFlags = new ArrayList<Image>();
    private List<Integer> lLoadedFlags_TagsIDs = new ArrayList<Integer>();

    protected Menu_CreateScenario_Cores_AddCiv_List() {
        ArrayList<MenuElement> menuElements = new ArrayList<MenuElement>();
        FileHandle tempFileT = Gdx.files.internal("game/civilizations/Age_of_Civilizations");
        String tempT = tempFileT.readString();
        String[] tagsSPLITED = tempT.split(";");
        String[] tagsSPLITED_ED = new String[]{};
        try {
            FileHandle tempFileT_ED = null;
            tempFileT_ED = CFG.isAndroid() ? Gdx.files.local("game/civilizations_editor/Age_of_Civilizations") : Gdx.files.internal("game/civilizations_editor/Age_of_Civilizations");
            String tempT_ED = tempFileT_ED.readString();
            tagsSPLITED_ED = tempT_ED.split(";");
        }
        catch (GdxRuntimeException tempFileT_ED) {
            // empty catch block
        }
        this.lCivsTags = new ArrayList<String>();
        ArrayList<String> lTempNames = new ArrayList<String>();
        ArrayList<String> lTempTags = new ArrayList<String>();
        menuElements.add(new Slider_BG(CFG.langManager.get("PercentageOfPopulation"), 0, CFG.PADDING * 2, CFG.GAME_WIDTH, CFG.BUTTON_HEIGHT, 1, 99, CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID){

            @Override
            protected String getDrawText() {
                return this.getText() + ": " + this.getCurrent() + "%";
            }
        });
        if (CFG.sSearch != null && CFG.sSearch.length() > 0) {
            int i;
            int iSize = tagsSPLITED.length;
            for (i = 0; i < iSize; ++i) {
                if (CFG.langManager.getCiv(tagsSPLITED[i]).toLowerCase().indexOf(CFG.sSearch.toLowerCase()) < 0 || CFG.isInTheGame(tagsSPLITED[i])) continue;
                lTempNames.add(CFG.langManager.getCiv(tagsSPLITED[i]));
                lTempTags.add(tagsSPLITED[i]);
            }
            iSize = tagsSPLITED_ED.length;
            for (i = 0; i < iSize; ++i) {
                if (CFG.langManager.getCiv(tagsSPLITED_ED[i]).toLowerCase().indexOf(CFG.sSearch.toLowerCase()) < 0 || CFG.isInTheGame(tagsSPLITED_ED[i])) continue;
                lTempNames.add(CFG.langManager.getCiv(tagsSPLITED_ED[i]));
                lTempTags.add(tagsSPLITED_ED[i]);
            }
            CFG.menuManager.menuCreateScenario_Cores_AddCiv_UpdateTitle(lTempNames.size());
            int nPosY = 0;
            int tID = 0;
            while (lTempNames.size() > 0) {
                int toAddID = 0;
                for (int i2 = 1; i2 < lTempNames.size(); ++i2) {
                    if (!CFG.compareAlphabetic_TwoString((String)lTempNames.get(toAddID), (String)lTempNames.get(i2))) continue;
                    toAddID = i2;
                }
                menuElements.add(new Button_Menu(CFG.langManager.getCiv((String)lTempTags.get(toAddID)), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_HEIGHT * (nPosY + 1) + CFG.PADDING * (nPosY + 3), CFG.GAME_WIDTH - (CFG.BUTTON_WIDTH + CFG.BUTTON_WIDTH / 2), CFG.BUTTON_HEIGHT, true));
                menuElements.add(new Button_Menu_Classic_Wiki(tID++, CFG.GAME_WIDTH - (CFG.BUTTON_WIDTH + CFG.BUTTON_WIDTH / 2), CFG.BUTTON_HEIGHT * (nPosY + 1) + CFG.PADDING * (nPosY + 3), CFG.BUTTON_WIDTH + CFG.BUTTON_WIDTH / 2, CFG.BUTTON_HEIGHT, true){

                    @Override
                    protected void buildElementHover() {
                        try {
                            ArrayList<MenuElement_Hover_v2_Element2> nElements = new ArrayList<MenuElement_Hover_v2_Element2>();
                            ArrayList<MenuElement_Hover_v2_Element_Type> nData = new ArrayList<MenuElement_Hover_v2_Element_Type>();
                            nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("Wiki") + ": "));
                            nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.getWikiInormationsLink_Clear((String)Menu_CreateScenario_Cores_AddCiv_List.this.lCivsTags.get(this.getTextPos())), CFG.COLOR_BUTTON_GAME_TEXT_ACTIVE));
                            nElements.add(new MenuElement_Hover_v2_Element2(nData));
                            nData.clear();
                            this.menuElementHover = new MenuElement_Hover_v2(nElements);
                        }
                        catch (IndexOutOfBoundsException ex) {
                            super.buildElementHover();
                        }
                    }
                });
                this.lCivsTags.add((String)lTempTags.get(toAddID));
                lTempNames.remove(toAddID);
                lTempTags.remove(toAddID);
                ++nPosY;
            }
        } else if (CFG.chosen_AlphabetCharachter == null) {
            int i;
            int iSize = tagsSPLITED.length;
            for (i = 0; i < iSize; ++i) {
                if (CFG.isInTheGame(tagsSPLITED[i])) continue;
                lTempNames.add(CFG.langManager.getCiv(tagsSPLITED[i]));
                lTempTags.add(tagsSPLITED[i]);
            }
            iSize = tagsSPLITED_ED.length;
            for (i = 0; i < iSize; ++i) {
                if (CFG.isInTheGame(tagsSPLITED_ED[i])) continue;
                lTempNames.add(CFG.langManager.getCiv(tagsSPLITED_ED[i]));
                lTempTags.add(tagsSPLITED_ED[i]);
            }
            CFG.menuManager.menuCreateScenario_Cores_AddCiv_UpdateTitle(lTempNames.size());
            int nPosY = 0;
            int tID = 0;
            while (lTempNames.size() > 0) {
                int toAddID = 0;
                for (int i3 = 1; i3 < lTempNames.size(); ++i3) {
                    if (!CFG.compareAlphabetic_TwoString((String)lTempNames.get(toAddID), (String)lTempNames.get(i3))) continue;
                    toAddID = i3;
                }
                menuElements.add(new Button_Menu(CFG.langManager.getCiv((String)lTempTags.get(toAddID)), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_HEIGHT * (nPosY + 1) + CFG.PADDING * (nPosY + 3), CFG.GAME_WIDTH - (CFG.BUTTON_WIDTH + CFG.BUTTON_WIDTH / 2), CFG.BUTTON_HEIGHT, true));
                menuElements.add(new Button_Menu_Classic_Wiki(tID++, CFG.GAME_WIDTH - (CFG.BUTTON_WIDTH + CFG.BUTTON_WIDTH / 2), CFG.BUTTON_HEIGHT * (nPosY + 1) + CFG.PADDING * (nPosY + 3), CFG.BUTTON_WIDTH + CFG.BUTTON_WIDTH / 2, CFG.BUTTON_HEIGHT, true){

                    @Override
                    protected void buildElementHover() {
                        try {
                            ArrayList<MenuElement_Hover_v2_Element2> nElements = new ArrayList<MenuElement_Hover_v2_Element2>();
                            ArrayList<MenuElement_Hover_v2_Element_Type> nData = new ArrayList<MenuElement_Hover_v2_Element_Type>();
                            nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("Wiki") + ": "));
                            nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.getWikiInormationsLink_Clear((String)Menu_CreateScenario_Cores_AddCiv_List.this.lCivsTags.get(this.getTextPos())), CFG.COLOR_BUTTON_GAME_TEXT_ACTIVE));
                            nElements.add(new MenuElement_Hover_v2_Element2(nData));
                            nData.clear();
                            this.menuElementHover = new MenuElement_Hover_v2(nElements);
                        }
                        catch (IndexOutOfBoundsException ex) {
                            super.buildElementHover();
                        }
                    }
                });
                this.lCivsTags.add((String)lTempTags.get(toAddID));
                lTempNames.remove(toAddID);
                lTempTags.remove(toAddID);
                ++nPosY;
            }
        } else {
            int i;
            int iSize = tagsSPLITED.length;
            for (i = 0; i < iSize; ++i) {
                if (CFG.langManager.getCiv(tagsSPLITED[i]).charAt(0) != CFG.chosen_AlphabetCharachter.charAt(0) || CFG.isInTheGame(tagsSPLITED[i])) continue;
                lTempNames.add(CFG.langManager.getCiv(tagsSPLITED[i]));
                lTempTags.add(tagsSPLITED[i]);
            }
            iSize = tagsSPLITED_ED.length;
            for (i = 0; i < iSize; ++i) {
                if (CFG.langManager.getCiv(tagsSPLITED_ED[i]).charAt(0) != CFG.chosen_AlphabetCharachter.charAt(0) || CFG.isInTheGame(tagsSPLITED_ED[i])) continue;
                lTempNames.add(CFG.langManager.getCiv(tagsSPLITED_ED[i]));
                lTempTags.add(tagsSPLITED_ED[i]);
            }
            CFG.menuManager.menuCreateScenario_Cores_AddCiv_UpdateTitle(lTempNames.size());
            int nPosY = 0;
            int tID = 0;
            while (lTempNames.size() > 0) {
                int toAddID = 0;
                for (int i4 = 1; i4 < lTempNames.size(); ++i4) {
                    if (!CFG.compareAlphabetic_TwoString((String)lTempNames.get(toAddID), (String)lTempNames.get(i4))) continue;
                    toAddID = i4;
                }
                menuElements.add(new Button_Menu(CFG.langManager.getCiv((String)lTempTags.get(toAddID)), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_HEIGHT * (nPosY + 1) + CFG.PADDING * (nPosY + 3), CFG.GAME_WIDTH - (CFG.BUTTON_WIDTH + CFG.BUTTON_WIDTH / 2), CFG.BUTTON_HEIGHT, true));
                menuElements.add(new Button_Menu_Classic_Wiki(tID++, CFG.GAME_WIDTH - (CFG.BUTTON_WIDTH + CFG.BUTTON_WIDTH / 2), CFG.BUTTON_HEIGHT * (nPosY + 1) + CFG.PADDING * (nPosY + 3), CFG.BUTTON_WIDTH + CFG.BUTTON_WIDTH / 2, CFG.BUTTON_HEIGHT, true){

                    @Override
                    protected void buildElementHover() {
                        try {
                            ArrayList<MenuElement_Hover_v2_Element2> nElements = new ArrayList<MenuElement_Hover_v2_Element2>();
                            ArrayList<MenuElement_Hover_v2_Element_Type> nData = new ArrayList<MenuElement_Hover_v2_Element_Type>();
                            nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("Wiki") + ": "));
                            nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.getWikiInormationsLink_Clear((String)Menu_CreateScenario_Cores_AddCiv_List.this.lCivsTags.get(this.getTextPos())), CFG.COLOR_BUTTON_GAME_TEXT_ACTIVE));
                            nElements.add(new MenuElement_Hover_v2_Element2(nData));
                            nData.clear();
                            this.menuElementHover = new MenuElement_Hover_v2(nElements);
                        }
                        catch (IndexOutOfBoundsException ex) {
                            super.buildElementHover();
                        }
                    }
                });
                this.lCivsTags.add((String)lTempTags.get(toAddID));
                lTempNames.remove(toAddID);
                lTempTags.remove(toAddID);
                ++nPosY;
            }
        }
        this.initMenu(null, 0, CFG.BUTTON_HEIGHT * 3 / 4 + CFG.BUTTON_HEIGHT + CFG.PADDING, CFG.GAME_WIDTH, CFG.GAME_HEIGHT - CFG.BUTTON_HEIGHT * 3 / 4 - CFG.BUTTON_HEIGHT - CFG.BUTTON_HEIGHT - CFG.PADDING * 2, menuElements, true, false);
        this.updateLanguage();
    }

    @Override
    protected void updateLanguage() {
        if (CFG.chosen_AlphabetCharachter == null && CFG.sSearch == null) {
            this.getMenuElement(0).setText(CFG.langManager.get("RandomCivilization"));
        }
    }

    @Override
    protected void updateMenuElements_IsInView() {
        int tempRandomButton;
        super.updateMenuElements_IsInView();
        for (int i = tempRandomButton = 1; i < this.getMenuElementsSize(); i += 2) {
            int tempTagID = this.getIsLoaded(this.lCivsTags.get((i - tempRandomButton) / 2));
            if (this.getMenuElement(i).getIsInView()) {
                if (tempTagID >= 0) continue;
                this.loadFlag((i - tempRandomButton) / 2);
                continue;
            }
            if (tempTagID < 0) continue;
            this.lFlags.get(tempTagID).getTexture().dispose();
            this.lFlags.set(tempTagID, null);
            this.lFlags.remove(tempTagID);
            this.lLoadedFlags_TagsIDs.remove(tempTagID);
        }
    }

    private final int getIsLoaded(String nCivTag) {
        for (int i = 0; i < this.lLoadedFlags_TagsIDs.size(); ++i) {
            if (!this.lCivsTags.get(this.lLoadedFlags_TagsIDs.get(i)).equals(nCivTag)) continue;
            return i;
        }
        return -1;
    }

    private final int getFlagID(int nCivTagID) {
        for (int i = 0; i < this.lLoadedFlags_TagsIDs.size(); ++i) {
            if (this.lLoadedFlags_TagsIDs.get(i) != nCivTagID) continue;
            return i;
        }
        return 0;
    }

    private final void loadFlag(int nCivTagID) {
        block9: {
            try {
                try {
                    this.lFlags.add(new Image(new Texture(Gdx.files.internal("game/flags/" + this.lCivsTags.get(nCivTagID) + ".png")), Texture.TextureFilter.Nearest));
                }
                catch (GdxRuntimeException e) {
                    try {
                        this.lFlags.add(new Image(new Texture(Gdx.files.internal("game/flags/" + CFG.ideologiesManager.getRealTag(this.lCivsTags.get(nCivTagID)) + ".png")), Texture.TextureFilter.Nearest));
                    }
                    catch (GdxRuntimeException ex) {
                        if (CFG.isAndroid()) {
                            try {
                                this.lFlags.add(new Image(new Texture(Gdx.files.local("game/civilizations_editor/" + this.lCivsTags.get(nCivTagID) + "/" + this.lCivsTags.get(nCivTagID) + "_FL.png")), Texture.TextureFilter.Nearest));
                            }
                            catch (GdxRuntimeException erq) {
                                this.lFlags.add(new Image(new Texture(Gdx.files.internal("game/civilizations_editor/" + this.lCivsTags.get(nCivTagID) + "/" + this.lCivsTags.get(nCivTagID) + "_FL.png")), Texture.TextureFilter.Nearest));
                            }
                            break block9;
                        }
                        this.lFlags.add(new Image(new Texture(Gdx.files.internal("game/civilizations_editor/" + this.lCivsTags.get(nCivTagID) + "/" + this.lCivsTags.get(nCivTagID) + "_FL.png")), Texture.TextureFilter.Nearest));
                    }
                }
            }
            catch (GdxRuntimeException e) {
                this.lFlags.add(new Image(new Texture(Gdx.files.internal("game/flags/ran.png")), Texture.TextureFilter.Nearest));
            }
        }
        this.lLoadedFlags_TagsIDs.add(nCivTagID);
    }

    @Override
    protected void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClip(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenu(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        int tempRandomButton = 1;
        try {
            for (int i = tempRandomButton; i < this.getMenuElementsSize(); i += 2) {
                if (!this.getMenuElement(i).getIsInView()) continue;
                this.lFlags.get(this.getFlagID((i - tempRandomButton) / 2)).draw(oSB, this.getMenuElement(i).getPosX() + this.getMenuElement(i).getTextPos() / 2 - CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, this.getMenuElement(i).getPosY() + this.getMenuPosY() + this.getMenuElement(i).getHeight() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - this.lFlags.get(this.getFlagID((i - tempRandomButton) / 2)).getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                ImageManager.getImage(Images.flag_rect).draw(oSB, this.getMenuElement(i).getPosX() + this.getMenuElement(i).getTextPos() / 2 - CFG.CIV_FLAG_WIDTH / 2 + iTranslateX, this.getMenuElement(i).getPosY() + this.getMenuPosY() + this.getMenuElement(i).getHeight() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
        super.endClip(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    protected final void actionElement(int iID) {
        switch (iID) {
            case 0: {
                CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = this.getMenuElement(iID).getCurrent();
                return;
            }
        }
        if (--iID % 2 == 0) {
            CFG.chosen_AlphabetCharachter = null;
            CFG.sSearch = null;
            CFG.game.createScenarioAddCivilization(this.lCivsTags.get(iID / 2), -1, false);
            for (int i = 0; i < CFG.game.getSelectedProvinces().getProvincesSize(); ++i) {
                CFG.province_Cores_GameData.addCore(CFG.game.getSelectedProvinces().getProvince(i), CFG.game.getProvince(CFG.game.getSelectedProvinces().getProvince(i)).getCivID(), 100);
                int tID = CFG.game.getCivsSize() - 1;
                CFG.game.getProvince(CFG.game.getSelectedProvinces().getProvince(i)).getCore().addNewCore(tID, 1);
                CFG.province_Cores_GameData.addCore(CFG.game.getSelectedProvinces().getProvince(i), tID, CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID);
            }
            CFG.game.getSelectedProvinces().clearSelectedProvinces();
            if (CFG.game.getActiveProvinceID() >= 0 && !CFG.game.getProvince(CFG.game.getActiveProvinceID()).getSeaProvince() && CFG.game.getProvince(CFG.game.getActiveProvinceID()).getWasteland() < 0) {
                CFG.game.getSelectedProvinces().addProvince(CFG.game.getActiveProvinceID());
            }
            this.onBack();
            this.onBackPressed();
        } else {
            CFG.EDITOR_ACTIVE_GAMEDATA_TAG = this.lCivsTags.get(iID / 2);
            CFG.setDialogType(Dialog.GO_TO_WIKI);
        }
    }

    private final void onBack() {
        CFG.menuManager.setViewID(Menu.eCREATE_SCENARIO_CORES);
    }

    @Override
    protected void onBackPressed() {
        for (int i = 0; i < this.lFlags.size(); ++i) {
            this.lFlags.get(i).getTexture().dispose();
        }
        this.lFlags.clear();
        this.lLoadedFlags_TagsIDs.clear();
        this.lCivsTags.clear();
    }
}

