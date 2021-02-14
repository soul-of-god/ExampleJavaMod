package lightglories;

import arc.*;
import arc.func.*;
import arc.util.Log;
import lightglories.util.*;
import mindustry.*;
import mindustry.ctype.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.mod.Mods.*;
import lightglories.content.*;

public class LightGlories extends Mod{
    public static final String githubURL = "XXX";
    public static final String shortName = "xXX";
    public static SettingAdder settingAdder = new SettingAdder();
    public static XeloUtil pushUtil = new XeloUtil();
    public static MobileFunctions mobileUtil = new MobileFunctions();

    private final ContentList[] mindyContent = {
            new OverWriter(),
            new MindyStatusEffects(),
            new MindyBullets(),
            new MindyBlocks()
    };

    public LightGlories() {
        super();
        MindySounds.load();
        pushUtil.init();
        if(Vars.mobile) mobileUtil.init();

        Events.on(DisposeEvent.class, e -> {
            MindySounds.dispose();
        });

        Core.settings.defaults("slimeeffect", true, "correctview", false, "accelballs", true);
        Events.on(ClientLoadEvent.class, e -> {
            settingAdder.init();
        });
    }

    @Override
    public void loadContent(){
        for(ContentList list : mindyContent){
            list.load();

            Log.info("@: Loaded content list: @", getClass().getSimpleName(), list.getClass().getSimpleName());
        }
    }
}