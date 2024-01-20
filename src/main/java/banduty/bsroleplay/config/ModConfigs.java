package banduty.bsroleplay.config;

import banduty.bsroleplay.BsRolePlay;
import com.mojang.datafixers.util.Pair;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static int PHARAOH_STAFF_COOLDOWN;
    public static int HOOK_COOLDOWN;
    public static int JUDGE_HAMMER_COOLDOWN;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(BsRolePlay.MOD_ID + "config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("pharaoh_staff_cooldown", 3), "(Seconds)");
        configs.addKeyValuePair(new Pair<>("hook_cooldown", 5), "(Seconds)");
        configs.addKeyValuePair(new Pair<>("judge_hammer_cooldown", 1), "(Seconds)");
    }

    private static void assignConfigs() {
        PHARAOH_STAFF_COOLDOWN = CONFIG.getOrDefault("pharaoh_staff_cooldown", 3);
        HOOK_COOLDOWN = CONFIG.getOrDefault("hook_cooldown", 5);
        JUDGE_HAMMER_COOLDOWN = CONFIG.getOrDefault("judge_hammer_cooldown", 1);

        System.out.println("All " + configs.getConfigsList().size() + " have been set properly");
    }
}
