package net.asterite.mixin;

import com.mojang.authlib.GameProfile;
import net.asterite.Faculty;
import net.asterite.item.ModItemRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.encryption.PlayerPublicKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(AbstractClientPlayerEntity.class)
public abstract class AbstractClientPlayerEntityMixin extends PlayerEntity {

    public AbstractClientPlayerEntityMixin(World world, BlockPos blockPos, float f, GameProfile gameProfile, @Nullable PlayerPublicKey playerPublicKey) {
        super(world, blockPos, f, gameProfile);
    }

    @Override
    public boolean shouldRender(double cameraX, double cameraY, double cameraZ) {
        if(this.getOffHandStack().getItem() == ModItemRegistry.ENVISIONER) {
            return false;
        }
        return super.shouldRender(cameraX, cameraY, cameraZ);
    }

    @Override
    public boolean shouldRenderName() {
        if(this.getOffHandStack().getItem() == ModItemRegistry.ENVISIONER) {
            return false;
        }
        return super.shouldRenderName();
    }

}
