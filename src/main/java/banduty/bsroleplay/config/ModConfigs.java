package banduty.bsroleplay.config;

import banduty.bsroleplay.BsRolePlay;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = BsRolePlay.MOD_ID)
@Config.Gui.Background("minecraft:textures/block/oak_plank.png")
public class ModConfigs extends PartitioningSerializer.GlobalData {

    @ConfigEntry.Category("common")
    @ConfigEntry.Gui.TransitiveObject()
    public Common common = new Common();

    @Config(name = BsRolePlay.MOD_ID)
    public static final class Common implements ConfigData {

        @ConfigEntry.Gui.Tooltip(count = 2)
        @Comment("Allow Pharaoh Staff throw Lightnings | Default: true")
        public boolean modifyPharaohStaffLightning = true;

        @ConfigEntry.Gui.Tooltip(count = 2)
        @Comment("Allow Hook spawn Evoker Fang | Default: true")
        public boolean modifyHookEvokerFang = true;

        @ConfigEntry.Gui.Tooltip(count = 2)
        @Comment("Allow Judge Hammer make Sound | Default: true")
        public boolean modifyJudgeHammerSound = true;

        @ConfigEntry.Gui.Tooltip(count = 2)
        @Comment("""
                Pharaoh Staff Cooldown in Seconds | Default: 5
                """)
        int pharaohStaffCooldown = 5;

        public int getPharaohStaffCooldown() {
            return Math.max(0, pharaohStaffCooldown);
        }

        @ConfigEntry.Gui.Tooltip(count = 2)
        @Comment("""
                Hook Cooldown in Seconds | Default: 4
                """)
        int hookCooldown = 4;

        public int getHookCooldown() {
            return Math.max(0, hookCooldown);
        }

        @ConfigEntry.Gui.Tooltip(count = 2)
        @Comment("""
                Judge Hammer Cooldown in Seconds | Default: 1
                """)
        int judgeHammerCooldown = 1;

        public int getJudgeHammerCooldown() {
            return Math.max(0, judgeHammerCooldown);
        }

        @ConfigEntry.Gui.Tooltip(count = 2)
        @Comment("Show Item Tooltips | Default: true")
        public boolean showItemTooltips = true;
    }
}