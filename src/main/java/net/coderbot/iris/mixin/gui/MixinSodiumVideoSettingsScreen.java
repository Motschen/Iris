package net.coderbot.iris.mixin.gui;

import me.jellysquid.mods.sodium.client.gui.SodiumOptionsGUI;
import me.jellysquid.mods.sodium.client.gui.widgets.FlatButtonWidget;
import me.jellysquid.mods.sodium.client.util.Dim2i;
import net.coderbot.iris.gui.ShaderPackScreen;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Iterator;
import java.util.List;

@Mixin(value = SodiumOptionsGUI.class, remap = false)
public class MixinSodiumVideoSettingsScreen extends Screen {
	@Shadow @Final private List<Drawable> drawable;

	protected MixinSodiumVideoSettingsScreen(Text title) {
		super(title);
	}

	@Inject(at = @At("TAIL"),method = "rebuildGUI",remap = false)
	private void rebuildGUIOptions(CallbackInfo ci) {
		this.children.add(new FlatButtonWidget(new Dim2i(10,this.height - 30,100,20), "Shader Packs", this::openScreen ));
		Iterator var1 = this.children.iterator();

		while(var1.hasNext()) {
			Element element = (Element)var1.next();
			if (element instanceof Drawable) {
				this.drawable.add((Drawable)element);
			}
		}
	}
	private void openScreen() {
		client.openScreen(new ShaderPackScreen(this));
	}
}
