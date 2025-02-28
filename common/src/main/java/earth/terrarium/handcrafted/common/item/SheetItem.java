package earth.terrarium.handcrafted.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SheetItem extends Item {
    public SheetItem(Properties properties) {
        super(properties);
    }

    public ResourceLocation getTexture(boolean isDouble, ResourceLocation texture) {
        ResourceLocation item = Registry.ITEM.getKey(this);
        return new ResourceLocation(texture.getNamespace(), "textures/block/bed/" + (isDouble ? "double" : "single") + "/sheet/" + item.getPath() + ".png");
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        if (Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.handcrafted.sheet_help").withStyle(ChatFormatting.GRAY));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.handcrafted.hold_shift").withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
    }
}