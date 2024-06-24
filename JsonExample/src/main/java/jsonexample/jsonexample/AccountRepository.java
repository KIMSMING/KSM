package jsonexample.jsonexample;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.List;

public class AccountRepository {
    
    public void loadJson(String fileName, List<Account> accountList) throws Exception {
        if ( fileName == null || fileName.isEmpty()
                || accountList == null ) {
            return;
        }
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(fileName, Charset.defaultCharset());
        Object jobj = parser.parse(reader);

        JSONObject jsonObject = (JSONObject) jobj;
        reader.close();
        System.out.print(jsonObject);

        JSONArray jsonArray = (JSONArray) jsonObject.get("accounts");
        accountList.clear();
        for ( Object obj : jsonArray ) {
            JSONObject element = (JSONObject)obj;
            String name = (String) element.get("name");
            String bankAccount = (String) element.get("bankAccount");
            Long current = (Long) element.get("current");
            accountList.add(new Account(name, bankAccount, current.intValue()));
        }
    }

    public void saveJson(String fileName, List<Account> accountList) throws Exception {
        if ( fileName == null || fileName.isEmpty()
                || accountList == null || accountList.size() <= 0 ) {
            return;
        }
        JSONArray jsonArray = new JSONArray();
        for ( Account account : accountList ) {
            JSONObject jobj = new JSONObject();
            jobj.put("name", account.getName());
            jobj.put("bankAccount", account.getBankNumber());
            jobj.put("current", account.getCurrent());
            jsonArray.add(jobj);
        }
        JSONObject jroot = new JSONObject();
        jroot.put("accounts", jsonArray);

        FileWriter fileWriter = new FileWriter(fileName, Charset.defaultCharset());
        fileWriter.write(jroot.toString());
        fileWriter.flush();
        fileWriter.close();
    }
}