import com.kiribyte.fastfood.services.impl.*;
import com.kiribyte.fastfood.services.interfaces.*;

import javax.sound.midi.Receiver;

public class Main {
    public static void main(String[] args) {

        String name = "Kirill Misyuro";
        String deliveryAddress = "";

        ILoggerService loggerService = new LoggerConsoleImpl();

        IOrderReceiver orderPhoneReceiver = new ReceiverOrderPhoneImpl(loggerService);
        IOrderReceiver orderOnlineReceiver = new ReceiverOrderOnlineImpl(loggerService);
        IOrderStorage orderStorage = new StorageOrderImpl(loggerService);
        ICookingProcessor orderCookingProcessor = new SimpleCookingProcessorImpl(loggerService);
        IOrderDelivery orderPickupDelivery = new DeliveryPickupImpl(loggerService);
        IOrderDelivery orderCourierDelivery = new DeliveryCourierImpl(loggerService);


        //Заказ по телефону - самовывоз
        IFastFoodService service1 = new FastFoodService(orderPhoneReceiver,
                orderStorage,
                orderCookingProcessor,
                orderPickupDelivery);
        deliveryAddress="window";
        service1.handleOrder(name, deliveryAddress);


    }
}