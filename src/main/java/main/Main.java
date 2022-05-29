package main;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try(JedisPool jedisPool = new JedisPool(
            properties.getProperty("host"),
            Integer.parseInt(properties.get("port").toString())
        )){
            Jedis jedis = jedisPool.getResource();

            if (jedis.get("greet") == null){
                jedis.set("greet", "Hello, Redis!!!");
            }
            Logger.getGlobal().info(jedis.get("greet"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
