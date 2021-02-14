package lightglories.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.struct.*;
import lightglories.graphics.*;
import lightglories.world.blocks.defense.*;
import lightglories.world.blocks.defense.turrets.*;
import lightglories.world.blocks.defense.turrets.pattern.*;
import lightglories.world.blocks.distribution.*;
import lightglories.world.blocks.environment.*;
import lightglories.world.blocks.logic.*;
import lightglories.world.blocks.power.*;
import lightglories.world.blocks.production.*;
import lightglories.world.blocks.units.BoostPad;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.experimental.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.meta.*;

import static mindustry.type.ItemStack.with;

public class MindyBlocks implements ContentList {
    //environment
    public static Block radiation, exoticMatter, present,
    //payloads
    payCannon, payCatapult, blockWorkshop, blockFactory, blockPacker, blockUnpacker, payDeconstructor, payDestroyer, payEradicator,
    //pistons
    piston, stickyPiston, pistonInfi, stickyPistonInfi, sporeSlime, sporeSlimeSided, surgeSlime, accel, cloner, spinner,
    //drills
    drillMini, drillMega,
    //units
    boostPad,
    //logic
    linkPin,
    //turrets
    hopeBringer;

    @Override
    public void load() {
        radiation = new GlowPowder("radiation", 0){{
            color1 = Pal.lancerLaser;
            color2 = Pal.heal;

            status = MindyStatusEffects.radiation;
            effect = MindyFx.directionalSmoke;
        }};

        exoticMatter = new GlowPowder("exotic-matter", 1){{
            color1 = Team.crux.color;
            color2 = Pal.sapBullet;

            status = MindyStatusEffects.controlSwap;
            duration = 3000f;
        }};

        payCannon = new PayloadTurret("payload-cannon"){{
            health = 2050;
            size = 5;
            recoilAmount = 7f;
            range = 315f;
            shootShake = 2f;
            shootSound = Sounds.shootBig;
            shootEffect = MindyFx.cannonShoot;
            smokeEffect = Fx.shootBigSmoke2;
            safeRange = 140f;
            reloadTime = 120f;
            rotateSpeed = 1.8f;
            maxPaySize = 3.5f;
            payloadOffset = 7f;
            payloadShootOffset = 8f;
            consumes.power(3.75f);
            requirements(Category.turret, with(Items.copper, 1000, Items.titanium, 750, Items.silicon, 450, Items.plastanium, 330));
        }};

        payCatapult = new PayloadTurret("payload-catapult"){{
            health = 3190;
            size = 7;
            recoilAmount = 9f;
            range = 520f;
            shootShake = 4f;
            shootSound = Sounds.plasmaboom;
            shootEffect = MindyFx.cannonShoot2;
            smokeEffect = Fx.shootBigSmoke2;
            damage = 2.3f;
            maxDamagePercent = 0.75f;
            safeRange = 190f;
            reloadTime = 250f;
            rotateSpeed = 1.3f;
            payloadOffset = 7.5f;
            payloadShootOffset = 7f;
            payloadScale = 0.85f;
            maxPaySize = 14.5f;
            consumes.power(7.25f);
            shootType = MindyBullets.payBulletBig;
            homingShootType = MindyBullets.homingPayBig;
            requirements(Category.turret, with(Items.copper, 1500, Items.titanium, 900, Items.silicon, 650, Items.plastanium, 390, Items.phaseFabric, 180, Items.surgeAlloy, 165));
        }};

        blockWorkshop = new BlockForge("block-workshop"){{
            health = 80;
            size = 5;
            minBlockSize = 3f;
            maxBlockSize = 4f;
            buildSpeed = 0.4f;
            liquidCapacity = 120f;
            consumes.power(3.25f);
            consumes.liquid(Liquids.water, 1f);
            requirements(Category.crafting, with(Items.thorium, 360, Items.phaseFabric, 120, Items.surgeAlloy, 60));
        }};

        blockFactory = new ConfigBlockForge("block-factory"){{
            health = 240;
            size = 7;
            minBlockSize = 1f;
            maxBlockSize = 6f;
            buildSpeed = 0.6f;
            liquidCapacity = 180f;
            consumes.power(4.75f);
            consumes.liquid(Liquids.cryofluid, 1.5f);
            requirements(Category.crafting, with(Items.thorium, 640, Items.silicon, 120, Items.plastanium, 320, Items.phaseFabric, 460, Items.surgeAlloy, 480));
        }};

        blockPacker = new BlockLoader("block-packer"){{
            health = 80;
            size = 5;
            maxBlockSize = 4f;
            consumes.power(3.25f);
            requirements(Category.distribution, with(Items.thorium, 360, Items.plastanium, 100, Items.phaseFabric, 80));
        }};

        blockUnpacker = new BlockUnloader("block-unpacker"){{
            health = 80;
            size = 5;
            maxBlockSize = 4f;
            consumes.power(3.25f);
            requirements(Category.distribution, with(Items.thorium, 360, Items.plastanium, 80, Items.phaseFabric, 100));
        }};

        payDeconstructor = new PayloadDeconstructor("payload-deconstructor"){{
            health = 80;
            size = 3;
            itemCapacity = 400;
            consumes.power(1f);
            requirements(Category.crafting, with(Items.copper, 100, Items.titanium, 50, Items.silicon, 25));
        }};

        payDestroyer = new PayloadDeconstructor("payload-destroyer"){{
            health = 120;
            size = 5;
            maxPaySize = 4f;
            buildSpeed = 0.75f;
            itemCapacity = 800;
            refundMultiplier = 1.75f;
            consumes.power(1.8f);
            requirements(Category.crafting, with(Items.copper, 360, Items.titanium, 95, Items.silicon, 65));
        }};

        payEradicator = new PayloadDeconstructor("payload-eradicator"){{
            health = 250;
            size = 7;
            maxPaySize = 10f;
            buildSpeed = 0.8f;
            itemCapacity = 1500;
            refundMultiplier = 2f;
            consumes.power(2.35f);
            consumes.liquid(Liquids.water, 0.8f);
            requirements(Category.crafting, with(Items.copper, 610, Items.titanium, 130, Items.silicon, 115, Items.phaseFabric, 35));
        }};

        piston = new Piston("piston"){{
            health = 200;
            consumes.power(1f);
            requirements(Category.distribution, with(Items.graphite, 25, Items.silicon, 10, Items.titanium, 15));
        }};

        stickyPiston = new Piston("piston-sticky"){{
            health = 200;
            consumes.power(1f);
            requirements(Category.distribution, with(Items.sporePod, 10, Items.graphite, 15, Items.silicon, 10, Items.titanium, 15));
            sticky = true;
        }};

        pistonInfi = new Piston("piston-infi", "lightglories-piston-arm", "lightglories-pistoninf"){{
            health = 200;
            consumes.power(1f);
            requirements(Category.distribution, BuildVisibility.sandboxOnly, with());

            maxBlocks = 512;
        }};

        stickyPistonInfi = new Piston("piston-sticky-infi", "lightglories-piston-sticky-arm", "lightglories-pistoninf"){{
            health = 200;
            consumes.power(1f);
            requirements(Category.distribution, BuildVisibility.sandboxOnly, with());
            sticky = true;

            maxBlocks = 512;
        }};

        sporeSlime = new SlimeBlock("spore-slime", 0){{
            health = 40;
            requirements(Category.distribution, with(Items.sporePod, 6));

            color = Color.valueOf("9E78DC");
        }};

        sporeSlimeSided = new SidedSlimeBlock("spore-slime-sided", 0){{
            health = 120;
            requirements(Category.distribution, with(Items.sporePod, 3, Items.lead, 3));

            color = Color.valueOf("9E78DC");
        }};

        surgeSlime = new SlimeBlock("surge-slime", 0){{
            health = 120;
            requirements(Category.distribution, with(Items.sporePod, 3, Items.surgeAlloy, 3));
            hasPower = true;
            outputsPower = true;
            consumesPower = false;

            color = Color.valueOf("F3E979");
        }};

        accel = new AccelBlock("accel"){{
            health = 150;
            requirements(Category.power, with(Items.lead, 25, Items.silicon, 20, Items.plastanium, 3));
        }};

        cloner = new BlockCloner("cloner"){{
            hasPower = true;
            consumes.power(0.6f);
            requirements(Category.distribution, with(Items.titanium, 30, Items.silicon, 35, Items.phaseFabric, 8));
        }};

        spinner = new Spinner("spinner"){{
            hasPower = true;
            consumes.power(0.3f);
            requirements(Category.distribution, with(Items.titanium, 30, Items.silicon, 35, Items.plastanium, 8));
        }};

        present = new PresentBox("present"){{
            requirements(Category.effect, with(Items.copper, 15, Items.graphite, 15));
        }};

        drillMini = new DrillTurret("drill-mini"){{
            range = 50f;
            itemCapacity = 25;
            hasPower = true;
            consumes.power(1f);
            requirements(Category.production, with(Items.copper, 15, Items.lead, 15, Items.graphite, 25, Items.titanium, 10, Items.silicon, 15));
        }};

        drillMega = new DrillTurret("drill-mega"){{
            size = 3;
            range = 120f;
            itemCapacity = 50;
            mineSpeed = 3.5f;
            minDrillTier = 1;
            maxDrillTier = 5;
            hasPower = true;
            laserWidth = 1.1f;
            laserOffset = 11f;
            consumes.power(9.6f);
            requirements(Category.production, with(Items.copper, 135, Items.titanium, 90, Items.silicon, 90, Items.plastanium, 45, Items.surgeAlloy, 15));
        }};

        boostPad = new BoostPad("boostpad"){{
            size = 2;
            requirements(Category.units, with(Items.lead, 24, Items.silicon, 10, Items.phaseFabric, 30));
        }};

        linkPin = new LinkPinner("linkpin"){{
            requirements(Category.logic, with( Items.graphite, 30,Items.silicon, 15, Items.metaglass, 30));
        }};

        hopeBringer = new MultiTurret("hopebringer"){{
            size = 9;
            health = 9999;
            powerUse = 90f;
            range = 600f;

            patterns = new TurretPattern[]{Patterns.starBlazing, Patterns.starBlazing, Patterns.chaosBuster, Patterns.starBlazing};
            requirements(Category.turret, with( Items.surgeAlloy, 9999));//TODO
        }};
    }
}
