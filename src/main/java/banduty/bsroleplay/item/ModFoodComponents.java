package banduty.bsroleplay.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent PILL = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 600), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 60), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300), 1f)
            .build();
}
