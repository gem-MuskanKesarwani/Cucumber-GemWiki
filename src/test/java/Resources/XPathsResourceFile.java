package Resources;

public class XPathsResourceFile {
    public String loginTitle="//div[@class='login-title']//child::div";
    public String subTitle="//div[@class='login-subtitle']//child::div";
    public String azureButton="//div[@role='listbox']//child::span";
    public String homeTitle="//div[@class='v-toolbar__title mx-3']//child::span[@class='subheading']";
    public String searchLabel="//div[@class='v-toolbar__content']//child::label[starts-with(@for,'input')]";
    public String searchBox="//div[@class='v-toolbar__content']//child::input[starts-with(@id,'input')]";
    public String searchIcon="//div[@class='v-toolbar__content']//child::div[@class='v-input__icon v-input__icon--prepend-inner']";
    public  String resultHeader="//div[@class='search-results-container']//child::div[starts-with(text(),'Found')]";
    public String noResult="//div[@class='search-results-container']//child::img[@alt='No Results']";
    public String resultContainer="//div[@role='list']//child::div[@role='listitem']";
    public String resultLanguage="//div[@role='list']//child::div[@role='listitem']//child::span[@class='v-chip__content']";
    public String closeButton="//div[@class='search-results']//child::button";
    public String closeText="//div[@class='search-results']//child::span[text()='Close']";
    public String noResultMessage="//div[@class='search-results-none']//child::div[@class='subheading']";
    public String welcomeText="//div[@class='headline grey--text text--darken-3']";


}
