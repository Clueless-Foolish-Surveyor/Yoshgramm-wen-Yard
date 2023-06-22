package data.missions.ywy_testfield;

import com.fs.starfarer.api.fleet.FleetGoal;
import com.fs.starfarer.api.fleet.FleetMemberType;
import com.fs.starfarer.api.mission.FleetSide;
import com.fs.starfarer.api.mission.MissionDefinitionAPI;
import com.fs.starfarer.api.mission.MissionDefinitionPlugin;

public class MissionDefinition implements MissionDefinitionPlugin {

  @Override
	public void defineMission(MissionDefinitionAPI api) {

		// Set up the fleets
		api.initFleet(FleetSide.PLAYER, "ISS", FleetGoal.ATTACK, false);
		api.initFleet(FleetSide.ENEMY, "ISS", FleetGoal.ATTACK, true);

		// Set a blurb for each fleet
		api.setFleetTagline(FleetSide.PLAYER, "Catalogue Fleet.");
		api.setFleetTagline(FleetSide.ENEMY, "Dummy Fleet.");
		
		// These show up as items in the bulleted list under 
		// "Tactical Objectives" on the mission detail screen
		api.addBriefingItem("Preview the capabilities of YWY's catalogue.");
		
		// Set up the player's fleet.
		api.addToFleet(FleetSide.PLAYER, "ywy_lohenli_dd_Standard", FleetMemberType.SHIP, "Lohen-li", true);
		api.addToFleet(FleetSide.PLAYER, "ywy_wuhauser_cve_ASC", FleetMemberType.SHIP, "Wuhauser", false);
		api.addToFleet(FleetSide.PLAYER, "ywy_lichterbo_cv_Standard", FleetMemberType.SHIP, "Lichter-bo", false);
		api.addToFleet(FleetSide.PLAYER, "ywy_luohoff_ca_Line", FleetMemberType.SHIP, "Luohoff", false);

		// Set up the enemy fleet.
		api.addToFleet(FleetSide.ENEMY, "atlas_Standard", FleetMemberType.SHIP, "Destined For Scrap", false);
		
		// api.defeatOnShipLoss("When Not Provided");
		
		// Set up the map.
		float width = 12000f;
		float height = 12000f;
		api.initMap((float)-width/2f, (float)width/2f, (float)-height/2f, (float)height/2f);
		
		float minX = -width/2;
		float minY = -height/2;
		
		// Add an asteroid field
		api.addAsteroidField(minX, minY + height / 2, 0, 8000f,
							 20f, 70f, 100);
		
	}

}
