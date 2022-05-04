package leaf.kkmoogleinterface.functions.moogleprojector;

import dan200.computercraft.api.lua.IArguments;
import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.lua.MethodResult;
import leaf.kkmoogleinterface.functions.IFunction;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import online.kingdomkeys.kingdomkeys.item.KeybladeItem;
import online.kingdomkeys.kingdomkeys.item.ModItems;

public class GetKeyblade implements IFunction
{
	@Override
	public String getName()
	{
		return "getKeyblade";
	}

	@Override
	public MethodResult run(IArguments args) throws LuaException
	{
		final String keybladePath = args.getString(0);
		final int keybladeLevel = args.optInt(1).orElse(0);

		for (RegistryObject<Item> entry : ModItems.ITEMS.getEntries())
		{
			if (!entry.isPresent() || !(entry.get() instanceof KeybladeItem))
			{
				continue;
			}
			final KeybladeItem keyblade = (KeybladeItem) entry.get();

			if (!keyblade.getRegistryName().getPath().equals(keybladePath))
			{
				continue;
			}

			int strength = keyblade.getStrength(keybladeLevel);
			int magic = keyblade.getMagic(keybladeLevel);
			float reach = keyblade.getReach();
			String description = keyblade.getDescription();

			return MethodResult.of(strength, magic, reach, description, keybladeLevel);
		}

		return MethodResult.of();
	}
}
