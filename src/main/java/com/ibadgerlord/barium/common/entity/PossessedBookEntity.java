package com.ibadgerlord.barium.common.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.*;

public class PossessedBookEntity extends HostileEntity implements RangedAttackMob {

    public PossessedBookEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void attack(LivingEntity target, float pullProgress) {

    }
}
