package controller;
 
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
 
import entity.cart.Cart;
import entity.cart.CartMedia;
import common.exception.InvalidDeliveryInfoException;
import entity.invoice.Invoice;
import entity.order.Order;
import entity.order.OrderMedia;
import views.screen.popup.PopupScreen;
 
/**
* This class controls the flow of place rush order usecase in our AIMS project
*/
public class PlaceRushOrderController extends PlaceOrderController {
 
    /**
     * Just for logging purpose
     */
    private static Logger LOGGER = utils.Utils.getLogger(PlaceRushOrderController.class.getName());
 
    /**
     * This method checks the availability of product and rush order eligibility
     * when user clicks PlaceRushOrder button
     * @throws SQLException
     */
    @Override
    public void placeOrder() throws SQLException {
        super.placeOrder();
        checkRushOrderEligibility();
    }
 
    /**
     * This method checks if the items in the cart are eligible for rush order
     * @throws SQLException
     */
    public void checkRushOrderEligibility() throws SQLException {
        List<CartMedia> cartMediaList = Cart.getCart().getListMedia();
        for (CartMedia cartMedia : cartMediaList) {
            if (!cartMedia.getMedia().isRushOrderEligible()) {
                throw new SQLException("Some items in the cart are not eligible for rush order.");
            }
        }
    }
 
    /**
     * This method creates the new rush Order based on the Cart
     * @return Order
     * @throws SQLException
     */
    @Override
    public Order createOrder() throws SQLException {
        Order order = super.createOrder();
        // Additional logic for rush order if needed
        return order;
    }
 
    /**
     * This method processes the shipping info and rush order specific info from user
     * @param info
     * @param isRushOrder
     * @throws InterruptedException
     * @throws IOException
     */
    public void processDeliveryInfo(HashMap<String, String> info, boolean isRushOrder) throws InterruptedException, IOException {
        LOGGER.info("Process Delivery Info for Rush Order");
        LOGGER.info(info.toString());
        validateDeliveryInfo(info);
        if (isRushOrder) {
            validateRushOrderDeliveryInfo(info);
        }
    }
 
    /**
     * Validates rush order specific delivery info
     * @param info
     * @throws InvalidDeliveryInfoException
     */
    public void validateRushOrderDeliveryInfo(HashMap<String, String> info) throws InvalidDeliveryInfoException {
        String address = info.get("address");
        if (address == null || !address.contains("Hà Nội")) {
            throw new InvalidDeliveryInfoException("Rush order is only available for addresses in Hà Nội.");
        }
 
        // Validate other rush order specific info if needed
    }
 
    /**
     * This method calculates the shipping fees of rush order
     * @param order
     * @param isRushOrder
     * @return shippingFee
     */
    public int calculateShippingFee(Order order, boolean isRushOrder) {
        int fees = super.calculateShippingFee(order);
        if (isRushOrder) {
            fees += 50000; // Example: add a fixed rush order fee
        }
        LOGGER.info("Order Amount: " + order.getAmount() + " -- Shipping Fees with Rush Order: " + fees);
        return fees;
    }
}

