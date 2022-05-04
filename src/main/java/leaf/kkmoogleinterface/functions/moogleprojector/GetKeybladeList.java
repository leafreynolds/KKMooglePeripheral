package leaf.kkmoogleinterface.functions.moogleprojector;

import dan200.computercraft.api.lua.IArguments;
import dan200.computercraft.api.lua.MethodResult;
import leaf.kkmoogleinterface.functions.IFunction;
import online.kingdomkeys.kingdomkeys.item.KeybladeItem;
import online.kingdomkeys.kingdomkeys.item.ModItems;

import java.util.Set;
import java.util.stream.Collectors;

public class GetKeybladeList implements IFunction
{
	@Override
	public String getName()
	{
		return "getKeybladeList";
	}

	@Override
	public MethodResult run(IArguments args)
	{
		Set<String> keyblades = ModItems.ITEMS
				.getEntries()
				.stream()
				.filter(itemRegistryObject -> itemRegistryObject.get() instanceof KeybladeItem)
				.map(item -> item.get().getRegistryName().getPath())
				.collect(Collectors.toSet());
		return MethodResult.of(keyblades);
	}
}
