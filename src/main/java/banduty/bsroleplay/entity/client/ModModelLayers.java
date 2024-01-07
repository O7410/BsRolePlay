package banduty.bsroleplay.entity.client;

import banduty.bsroleplay.BsRolePlay;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer HOLY_CLOUD =
            new EntityModelLayer(new Identifier(BsRolePlay.MOD_ID,"holy_cloud"), "main");
}
