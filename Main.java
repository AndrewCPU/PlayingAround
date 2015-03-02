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
    if(event.getMessage().equalsIgnoreCase("!kill"))
    {
      String[] args = event.getMessage().split(" ");
      Player p = Bukkit.getPlayer(args[1));
      if(p!=null)
      {
        if(godMode.contains(p.getName())
        {
          event.getPlayer().sendMessage(ChatColor.RED + "That player is in GOD MODE!");
        }
        else
        {
                  p.setHealth(0);
        p.sendMessage(ChatColor.RED + "You have been killed...");
        }
      }
      else
      {
        event.getPlayer().sendMessage(ChatColor.RED+ "That player is not online...");
      }
      event.setCancelled(true);
    }
    if(event.getMessage().equalsIgnoreCase("!gods"))
    {
      String list = "";
      for(String s : godMode)
      {
        list+=s + ", ";
      }
      event.getPlayer().sendMessage(ChatColor.RED + "The list of online gods: " + list);
      event.setCancelled(true);
    }
  }
  @EventHandler
  public void onLeave(PlayerQuitEvent event)
  {
    if(godMode.contains(event.getPlayer().getName())
    {
      godMode.remove(event.getPlayer().getName());
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
