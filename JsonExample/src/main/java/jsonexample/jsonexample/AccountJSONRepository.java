package jsonexample.jsonexample;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.List;

public class AccountJSONRepository implements AccountRepository {
    private static final String fileName = "data.json";

    @Override
    public void loadJson(List<Account> accountList) throws Exception {
        if ( accountList == null ) {
            return;
        }
        JSONParser parser = new JSONParser();
        File file = new File(fileName);
        if ( !file.exists() ) {
            return; // 파일이 없을때 실행하면 예외 없도록 처리함
        }
        FileReader reader = new FileReader(file, Charset.defaultCharset());
        JSONObject jsonObject = (JSONObject)parser.parse(reader);

        reader.close();
//        System.out.print(jsonObject);

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

    @Override
    public void saveJson(List<Account> accountList) throws Exception {
        if ( accountList == null || accountList.size() <= 0 ) {
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