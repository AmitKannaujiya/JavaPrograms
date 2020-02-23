package designConcepts.payment;

abstract public class BaseCardPayment extends BasePayment implements ICardPayment {
    private String cardName;
    private String cardNo;
    private CardType cardType;
    private String expiry;
    private int cvv;

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    @Override
    public void saveCardDetails(String name, String cardNo, CardType type, String expiry, int cvv) {
        setCardName(name);
        setCardNo(cardNo);
        setCardType(type);
        setCvv(cvv);
        setExpiry(expiry);
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "BaseCardPayment{" +
                "cardName='" + cardName + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", cardType=" + cardType +
                ", expiry='" + expiry + '\'' +
                ", cvv=" + cvv +
                '}';
    }
}
