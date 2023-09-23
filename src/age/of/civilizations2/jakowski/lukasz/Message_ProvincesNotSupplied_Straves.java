package age.of.civilizations2.jakowski.lukasz;

import java.util.ArrayList;
import java.util.List;

class Message_ProvincesNotSupplied_Straves extends Message {
   protected Message_ProvincesNotSupplied_Straves(int fromCivID, int iProvinceID, int iValue) {
      super(fromCivID, iValue);
      this.iValue2 = iProvinceID;
      this.messageType = Message_Type.PROVINCES_NOT_SUPPLIED_STRAVES;
      this.iNumOfTurnsLeft = 1;
   }

   @Override
   protected void onAction(int iMessageID) {
      CFG.game
         .getCiv(CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID())
         .getCivilization_Diplomacy_GameData()
         .messageBox
         .getMessage(iMessageID)
         .onDecline(CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID());
      CFG.game.getCiv(CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID()).getCivilization_Diplomacy_GameData().messageBox.removeMessage(iMessageID);
      CFG.menuManager.rebuildInGame_Messages();
   }

   @Override
   protected void onAccept(int iCivID) {
      if (CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID() == iCivID) {
         CFG.toast
            .setInView(
               CFG.langManager.get("ArmyStarvesToDeath") + ": -" + CFG.getNumberWithSpaces("" + this.iValue) + " " + CFG.langManager.get("Units"),
               CFG.COLOR_TEXT_MODIFIER_NEGATIVE2
            );
         CFG.toast.setTimeInView(4500);
         CFG.game.setActiveProvinceID(this.iValue2);
         if (!CFG.game.getProvince(CFG.game.getActiveProvinceID()).getDrawProvince()) {
            CFG.map.getMapCoordinates().centerToProvinceID(CFG.game.getActiveProvinceID());
         }
      }
   }

   @Override
   protected void onDecline(int iCivID) {
      if (CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID() == iCivID) {
         CFG.toast
            .setInView(
               CFG.langManager.get("ArmyStarvesToDeath") + ": -" + CFG.getNumberWithSpaces("" + this.iValue) + " " + CFG.langManager.get("Units"),
               CFG.COLOR_TEXT_MODIFIER_NEGATIVE2
            );
         CFG.toast.setTimeInView(4500);
         CFG.game.setActiveProvinceID(this.iValue2);
         if (!CFG.game.getProvince(CFG.game.getActiveProvinceID()).getDrawProvince()) {
            CFG.map.getMapCoordinates().centerToProvinceID(CFG.game.getActiveProvinceID());
         }
      }
   }

   @Override
   protected int getImageID() {
      return Images.diplo_army;
   }

   @Override
   protected int getBGImageID() {
      return Images.messages_r;
   }

   @Override
   protected MenuElement_Hover_v2 getHover() {
      List<MenuElement_Hover_v2_Element2> nElements = new ArrayList<>();
      List<MenuElement_Hover_v2_Element_Type> nData = new ArrayList<>();
      nData.add(new MenuElement_Hover_v2_Element_Type_Flag(this.iFromCivID));
      nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("ArmyStarvesToDeath") + ": "));
      nData.add(
         new MenuElement_Hover_v2_Element_Type_Text(
            "-" + CFG.getNumberWithSpaces("" + this.iValue) + " " + CFG.langManager.get("Units"), CFG.COLOR_TEXT_MODIFIER_NEGATIVE2
         )
      );
      nData.add(new MenuElement_Hover_v2_Element_Type_Image(Images.diplo_army, CFG.PADDING, 0));
      nElements.add(new MenuElement_Hover_v2_Element2(nData));
      nData.clear();
      nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("ProvinceIsNotSupplied"), CFG.COLOR_TEXT_MODIFIER_NEGATIVE2));
      nData.add(new MenuElement_Hover_v2_Element_Type_Image(Images.difficulty_hell, CFG.PADDING, 0));
      nElements.add(new MenuElement_Hover_v2_Element2(nData));
      nData.clear();
      nData.add(new MenuElement_Hover_v2_Element_Type_Space());
      nElements.add(new MenuElement_Hover_v2_Element2(nData));
      nData.clear();
      nData.add(new MenuElement_Hover_v2_Element_Type_Image(Images.diplo_message));
      nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("MessageWillExpireIn") + ": "));
      nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("TurnsX", this.iNumOfTurnsLeft) + " ", CFG.COLOR_TEXT_MODIFIER_NEUTRAL2));
      nData.add(
         new MenuElement_Hover_v2_Element_Type_Text(
            "[" + Game_Calendar.getDate_ByTurnID(Game_Calendar.TURN_ID + this.iNumOfTurnsLeft) + "]", CFG.COLOR_TEXT_MODIFIER_NEUTRAL
         )
      );
      nElements.add(new MenuElement_Hover_v2_Element2(nData));
      nData.clear();
      if (CFG.game.getCiv(this.iFromCivID).civGameData.leaderData != null) {
         nData.add(
            new MenuElement_Hover_v2_Element_Type_Text(CFG.game.getCiv(this.iFromCivID).civGameData.leaderData.getName(), CFG.COLOR_BUTTON_GAME_TEXT_ACTIVE)
         );
         nData.add(new MenuElement_Hover_v2_Element_Type_Flag(this.iFromCivID, CFG.PADDING, 0));
         nElements.add(new MenuElement_Hover_v2_Element2(nData));
         nData.clear();
      }

      return new MenuElement_Hover_v2(nElements);
   }
}
