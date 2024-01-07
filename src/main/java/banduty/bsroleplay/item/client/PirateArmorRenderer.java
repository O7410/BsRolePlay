package banduty.bsroleplay.item.client;

import banduty.bsroleplay.item.custom.PirateArmorItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class PirateArmorRenderer extends GeoArmorRenderer<PirateArmorItem> {
    public PirateArmorRenderer() {
        super(new PirateArmorModel());
    }
}
