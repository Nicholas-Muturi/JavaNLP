package models;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class NLP_Engine {
    private Properties props;
    private StanfordCoreNLP pipeline;
    private CoreDocument document;
    private List<CoreLabel> tokens;
    private List<CoreSentence> sentences;
    private Annotation annotationDoc;

    public NLP_Engine(){
        props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos");
        pipeline = new StanfordCoreNLP(props);
    }

    public void annotate(String input){
        document = new CoreDocument(input);
        annotationDoc = new Annotation(input);
        pipeline.annotate(document);
    }

    public List<CoreLabel> getTokens(){
        return document.tokens();
    }

    public List<CoreSentence> getSentences(){
        return document.sentences();
    }

    public CoreDocument getDocument(){
        return document;
    }

    public List<String> getWords(){
        return tokens.stream().map(CoreLabel::toString).collect(Collectors.toList());
    }

    public List<String> getStringedSentences(){
        return document.sentences().stream().map(CoreSentence::toString).collect(Collectors.toList());
    }



}
