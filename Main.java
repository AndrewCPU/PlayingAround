package net.Andrewcpu;

public class Main extends JavaPlugin implements Listener
{
  public void onEnable()
  {
    getServer().getPluginManager().registerEvents(this, this);
  }
  List<String> godMode = new ArrayList<String>();
  @EventHandler
  public void onChat(AsyncPlayerChatEvent event)
  {
    Player p = event.getPlayer();
    if(event.getMessage().equalsIgnoreCase("!god"))
    {
      if(godMode.contains(p.getName())
      {
        godMode.remove(p.getName());
        p.sendMessage(ChatColor.RED + "You are no longer in GOD MODE!");
      }
      else
      {
        godMode.add(p.getName());
        p.sendMessage(ChatColor.GREEN + "You are now in GOD MODE!");
      }
      event.setCancelled(true);
    }
  }
  @EventHandler
  public void onDamage(EntityDamageEvent event)
  {
    if(event.getEntity() instanceof Player)
    {
      Player p = (Player)event.getEntity();
      if(godMode.contains(p.getName())
      {
        event.setCancelled(true);
      }
    }
  }
}
